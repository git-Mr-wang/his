package com.qhit.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sun.org.glassfish.gmbal.Description;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;


/**
 * Created by Administrator on 2018/7/25 0025.
 */
public class BaseDao {

    private static ComboPooledDataSource comboPooledDataSource = null;
    static {
        comboPooledDataSource = new ComboPooledDataSource();
    }

    public Connection conn = null;
    public ResultSet set = null;
    public PreparedStatement ps =null;
    /**
     * 获取连接
     * @return
     */

    public   Connection getConn(){
        try {

            //获取连接对象
            conn = comboPooledDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭连接
     */
    public  void closeConn(){
        if(set!=null) set=null;
        if(ps!=null) ps=null;
        if(conn!=null) try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 插入数据
     * @param object
     */
    public boolean insert(Object object){
        try {
            // 获取连接
            Connection conn = getConn();
            // 获取类对象
            Class clazz = object.getClass();
            // 类名称(包名+类名)
            String[] names = clazz.getName().split("\\.");
            String className = names[names.length-1];
            String tableName = JavaBeanTodbTable(className);
            // 获取所有属性(包括私有属性)
            Field[] fields = clazz.getDeclaredFields();
            // 拼接sql语句
            StringBuffer buffer = new StringBuffer("insert into ");
            buffer.append(tableName+(" values("));
            for(Field f:fields){
                String fname = f.getName();
                String  upperCaseFname = toUpperCaseFirstOne(fname);
                Method method = clazz.getMethod("get"+upperCaseFname);
                Object result = method.invoke(object);
                //获取注解
                Annotation[] as = f.getAnnotations();
                //没有注解
                if(as.length==0){
                    if(result==null|| "".equals(result)){
                        //空
                        buffer.append(null+",");
                    }else if(f.getType().getName().equals("java.lang.Integer")||f.getType().getName().equals("java.lang.Double")||f.getType().getName().equals("java.lang.Float")){
                        //数字
                        buffer.append(result+",");
                    }else{
                        //非数字
                        buffer.append("'"+result+"',");
                    }
                }
            }
            //最后一个逗号截掉
            buffer.deleteCharAt(buffer.length()-1);
            buffer.append(")");
            // 执行插入
            PreparedStatement ps = conn.prepareStatement(buffer.toString());
            //插入
            int row = ps.executeUpdate();
            return row>0?true:false;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("插入失败");
        }finally {
            closeConn();
        }

        return  false;
    }

    public List freeFind(String sql){
        //通过sql获取表名  如果是多表，将数据存放在第一张表中
        String showTableName = findTableNameBySql(sql);
        List list = new ArrayList();
        try {
            // 获取连接
            Connection conn = getConn();
            // 获取执行对象
            ps = conn.prepareStatement(sql);


            //得到表名和类对象组成的Map集合
            Map<String,Class> tableClasses = new HashMap<>();
            //表名和实例对象组成的集合
            Map<String,List> tableObjects = new HashMap<>();
            ResultSet rs0 = ps.executeQuery();
            ResultSetMetaData metaData = rs0.getMetaData();
            while(rs0.next()){
                int count = metaData.getColumnCount();
                for (int i = 1; i <=count ; i++) {
                    String table = metaData.getTableName(i);
                    if(table==null||"".equals(table)){
                        table = showTableName;
                    }
                    String beanName = dbTableToJavaBean(table);
                    String javaPackageName = toLowerCaseFirstOne(beanName);
                    Class clazz = Class.forName("com.qhit."+javaPackageName+".pojo."+beanName);
                    Object object = clazz.newInstance();
                    tableClasses.put(table,clazz);
                    List l = new ArrayList();
                    tableObjects.put(table,l);
                }
            }
            // 执行查询
            set = ps.executeQuery();
            int rownum=0;
            while(set.next()){
                //实例化对象
                //Object object =  clazz.newInstance();
                //通过元数据查看有多少个字段
                int count = metaData.getColumnCount();
                for (int i = 1; i <=count ; i++) {
                    //表名 类对象
                    String table = metaData.getTableName(i);
                    if(table==null || "".equals(table)){
                        table = showTableName;
                    }
                    Class clazz = tableClasses.get(table);
                    Object object = null;
                    // 表名 实例化对象集合
                    List l = tableObjects.get(table);
                    if(rownum==l.size()){
                        object=clazz.newInstance();
                        l.add(object);
                    }else{
                        object = l.get(rownum);
                    }

                    //列名 小写
                    String columnName = metaData.getColumnName(i);
                    String javaCol = dbColsToJavaCols(columnName);
                    String upperCaseColumnName = toUpperCaseFirstOne(javaCol);
                    //列类型 大写
                    String type = metaData.getColumnTypeName(i);
                    Method m = null;
                    if(type.equals("VARCHAR")||type.equals("VARCHAR2")){
                        m = clazz.getMethod("set"+upperCaseColumnName,String.class);
                        m.invoke(object,set.getObject(i));
                    }else if(type.equals("INT")){
                        m = clazz.getMethod("set"+upperCaseColumnName,Integer.class);
                        m.invoke(object,set.getObject(i));
                    }else if(type.equals("FLOAT")){
                        m = clazz.getMethod("set"+upperCaseColumnName,Float.class);
                        m.invoke(object,set.getObject(i));
                    }else if(type.equals("DOUBLE")){
                        m = clazz.getMethod("set"+upperCaseColumnName,Double.class);
                        m.invoke(object,set.getObject(i));
                    }else if(type.equals("DATE")){
                        m = clazz.getMethod("set"+upperCaseColumnName,String.class);
                        String date = null;
                        if(set.getObject(i)!=null){
                            date = set.getDate(i).toString();
                        }
                        m.invoke(object,date);
                    }else if(type.equals("DATETIME")||type.equals("TIMESTAMP")){
                        m = clazz.getMethod("set"+upperCaseColumnName,String.class);
                        String datetime = null;
                        if(set.getObject(i)!=null){
                            datetime = set.getTimestamp(i).toString();
                        }
                        m.invoke(object,datetime);
                    }

                }
                rownum++;
            }
            // 遍历tableObjects 执行set对象的方法  分为realTable和filedTable realBean和filedBean  realObject fileObject
            // 真正的table,bean  属性table,bean
            Set<String> keyset = tableClasses.keySet();
            for(String realTable:keyset){
                Class clazz = tableClasses.get(realTable);  //realbean类对象
                Field[] fields = clazz.getDeclaredFields();
                for(Field f:fields){
                    Annotation[] as = f.getAnnotations();
                    for(Annotation a:as){
                        Description ds = (Description) a;
                        if("bean".equals(ds.value())){
                            // 属性bean
                            String filedBeanName = f.getName();
                            String upperCaseFiledBeanName = toUpperCaseFirstOne(filedBeanName);
                            String filedTable = JavaBeanTodbTable(upperCaseFiledBeanName);
                            Class filedBeanClass = Class.forName("com.qhit."+filedBeanName+".pojo."+upperCaseFiledBeanName); //属性bean 类对象
                            Method method = clazz.getMethod("set"+upperCaseFiledBeanName,filedBeanClass);
                            List realObjectList = tableObjects.get(realTable);
                            for (int i = 0; i <realObjectList.size() ; i++) {
                                Object realObject = realObjectList.get(i);
                                List fieldObjectList = tableObjects.get(filedTable);
                                if(fieldObjectList!=null && fieldObjectList.size()>0){
                                    Object filedObj = fieldObjectList.get(i);
                                    method.invoke(realObject,filedObj);
                                }
                            }

                        }else if("list".equals(ds.value())){
                            // 属性List  属性必须以List结尾
                            String filedName = f.getName();
                            String upperCaseFiledName = toUpperCaseFirstOne(filedName);
                            String filedBeanName = filedName.replace("List","");
                            String upperCaseFiledBeanName = toUpperCaseFirstOne(filedBeanName);
                            String filedTable = JavaBeanTodbTable(upperCaseFiledBeanName);
                            Class filedBeanClass = Class.forName("com.qhit."+filedBeanName+".pojo."+upperCaseFiledBeanName); //属性bean 类对象
                            Method method = clazz.getMethod("set"+upperCaseFiledName,List.class);
                            List realObjectList = tableObjects.get(realTable);

                            for (int i = 0; i <realObjectList.size() ; i++) {
                                Object realObject = realObjectList.get(i);
                                List fieldObjectList = tableObjects.get(filedTable);

                                if(fieldObjectList!=null && fieldObjectList.size()>0){
                                    //  集合中的对象去重复
                                    Set set = new HashSet(fieldObjectList);
                                    fieldObjectList = new ArrayList(set);
                                    method.invoke(realObject,fieldObjectList);
                                }
                            }

                        }
                    }

                }
            }
            list = tableObjects.get(showTableName.toLowerCase());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("查询失败");
        }finally {
            closeConn();
        }


        return list;
    }

    public static String toUpperCaseFirstOne(String tableName) {
        String result = "";
        if(tableName!=null && !"".equals(tableName)){
            result = tableName.substring(0,1).toUpperCase()+tableName.substring(1);
        }
        return result;

    }
    public static String toLowerCaseFirstOne(String tableName) {
        String result = "";
        if(tableName!=null && !"".equals(tableName)){
            result = tableName.substring(0,1).toLowerCase()+tableName.substring(1);
        }
        return result;

    }

    // 通过sql语句获取表名
    public static String findTableNameBySql(String sql) {
        int begin = sql.indexOf("from")+5;
        String tableName = sql.substring(begin).trim();
        if(tableName.indexOf(" ")!=-1){
            tableName = tableName.substring(0,tableName.indexOf(" "));
        }

        return tableName;
    }

    /**
     * 数据库表名对应bean名称
     * @param table
     * @return
     */
    public static String dbTableToJavaBean(String table){
        table=table.toLowerCase();
        String[] dbarr = table.split("_");
        String javaBean = "";
        for(String s: dbarr){
            javaBean += toUpperCaseFirstOne(s);
        }
        return javaBean;
    }

    /**
     * 数据库字段对应java字段名称
     * @param dbCols
     * @return
     */
    public static String dbColsToJavaCols(String dbCols){
        dbCols=dbCols.toLowerCase();
        String[] dbarr = dbCols.split("_");
        String javaCol = dbarr[0];
        for (int i = 1; i <dbarr.length ; i++) {
            javaCol += toUpperCaseFirstOne(dbarr[i]);
        }
        return javaCol;
    }

    /**
     * bean名称对应数据库名称
     * @param beanName
     * @return
     */
    public static String JavaBeanTodbTable(String beanName){
        char[] chars = beanName.toCharArray();
        String dbTable = ""+(char)(chars[0]+32);
        for (int i = 1; i < chars.length; i++) {
            if(chars[i]>='A' && chars[i]<='Z'){
                dbTable+="_"+(char)(chars[i]+32);
            }else{
                dbTable+=chars[i];
            }
        }
        return dbTable;
    }

    /**
     * java字段名称对应数据库字段
     * @param javaCol
     * @return
     */
    public static String JavaColsTodbCols(String javaCol){
        char[] chars = javaCol.toCharArray();
        String dbCol = "";
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]>='A' && chars[i]<='Z'){
                dbCol+="_"+(char)(chars[i]+32);
            }else{
                dbCol+=chars[i];
            }
        }
        return dbCol;
    }

    /**
     * 更新数据
     * @param object
     */
    public boolean update(Object object){
        try {
            // 获取连接
            Connection conn = getConn();
            // 获取类对象
            Class clazz = object.getClass();
            // 类名称(包名+类名)
            String[] names = clazz.getName().split("\\.");
            String className = names[names.length-1];
            String tableName = JavaBeanTodbTable(className);
            // 获取所有属性(包括私有属性)
            Field[] fields = clazz.getDeclaredFields();
            // 拼接sql语句
            StringBuffer buffer = new StringBuffer("update ");
            buffer.append(tableName+(" set "));
            String whereSql = "";
            for(int i=0;i<fields.length;i++){
                Field f = fields[i];
                String fname = f.getName();
                String dbCol = JavaColsTodbCols(fname);
                //获取注解
                Annotation[] as = f.getAnnotations();
                String upperCaseFname = toUpperCaseFirstOne(fname);
                Method method = clazz.getMethod("get"+upperCaseFname);
                Object result = method.invoke(object);
                //属性没有注解
                if(as.length==0){
                    //主键
                    if(i==0){
                        whereSql = " where "+dbCol+"="+result;
                    }else if(result==null||"".equals(result)){
                        //空
                        buffer.append(dbCol+"=null,");
                    }else if(f.getType().getName().equals("java.lang.Integer")||f.getType().getName().equals("java.lang.Double")||f.getType().getName().equals("java.lang.Float")){
                        //数字
                        buffer.append(dbCol+"="+result+",");
                    }else{
                        //非数字
                        buffer.append(dbCol+"='"+result+"',");
                    }

                }
            }
            //最后一个逗号截掉
            buffer.deleteCharAt(buffer.length()-1);
            buffer.append(whereSql);
            // 执行更新
            PreparedStatement ps = conn.prepareStatement(buffer.toString());
            //更新
            int row = ps.executeUpdate();
            return row>0?true:false;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("更新失败");
        }finally {
            closeConn();
        }

        return false;
    }

    /**
     * 更新数据
     * @param object
     */
    public boolean updateSelective(Object object){
        try {
            // 获取连接
            Connection conn = getConn();
            // 获取类对象
            Class clazz = object.getClass();
            // 类名称(包名+类名)
            String[] names = clazz.getName().split("\\.");
            String className = names[names.length-1];
            String tableName = JavaBeanTodbTable(className);
            // 获取所有属性(包括私有属性)
            Field[] fields = clazz.getDeclaredFields();
            // 拼接sql语句
            StringBuffer buffer = new StringBuffer("update ");
            buffer.append(tableName+(" set "));
            String whereSql = "";
            for(int i=0;i<fields.length;i++){
                Field f = fields[i];
                String fname = f.getName();
                String dbCol = JavaColsTodbCols(fname);
                //获取注解
                Annotation[] as = f.getAnnotations();
                String upperCaseFname = toUpperCaseFirstOne(fname);
                Method method = clazz.getMethod("get"+upperCaseFname);
                Object result = method.invoke(object);
                //属性没有注解
                if(as.length==0){
                    //主键
                    if(i==0){
                        whereSql = " where "+dbCol+"="+result;
                    }else if(result==null||"".equals(result)){
                        //空
//                        buffer.append(dbCol+"=null,");
                    }else if(f.getType().getName().equals("java.lang.Integer")||f.getType().getName().equals("java.lang.Double")||f.getType().getName().equals("java.lang.Float")){
                        //数字
                        buffer.append(dbCol+"="+result+",");
                    }else{
                        //非数字
                        buffer.append(dbCol+"='"+result+"',");
                    }

                }
            }
            //最后一个逗号截掉
            buffer.deleteCharAt(buffer.length()-1);
            buffer.append(whereSql);
            // 执行更新
            PreparedStatement ps = conn.prepareStatement(buffer.toString());
            //更新
            int row = ps.executeUpdate();
            return row>0?true:false;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("更新失败");
        }finally {
            closeConn();
        }

        return false;
    }


    /**
     * 删除数据
     * @param object
     */
    public boolean delete(Object object){
        try {
            // 获取连接
            Connection conn = getConn();
            // 获取类对象
            Class clazz = object.getClass();
            // 类名称(包名+类名)
            String[] names = clazz.getName().split("\\.");
            String className = names[names.length-1];
            String tableName = JavaBeanTodbTable(className);
            // 获取所有属性(包括私有属性)
            Field[] fields = clazz.getDeclaredFields();
            // 拼接sql语句
            StringBuffer buffer = new StringBuffer("delete from  ");
            buffer.append(tableName+(" where  "));
            // 主键
            Field f = fields[0];
            String fname = f.getName();
            String dbCol = JavaColsTodbCols(fname);
            String upperCaseFname = toUpperCaseFirstOne(fname);
            Method method = clazz.getMethod("get"+upperCaseFname);
            Object result = method.invoke(object);
            buffer.append(dbCol+"="+result);

            // 执行删除
            PreparedStatement ps = conn.prepareStatement(buffer.toString());
            //删除
            int row = ps.executeUpdate();
            return row>0?true:false;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("删除失败");
        }finally {
            closeConn();
        }

        return false;
    }

    /**
     * 更新或删除数据
     * @param sql
     */
    public boolean freeUpdate(String sql){
        try {
            // 获取连接
            Connection conn = getConn();

            // 执行更新或删除
            PreparedStatement ps = conn.prepareStatement(sql);
            int row = ps.executeUpdate();
            return row>0?true:false;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("更新失败");
        }finally {
            closeConn();
        }

        return false;
    }
    /**
     * 执行存储过程
     */
    public boolean execProc(String procName){
        try {
            // 获取连接
            Connection conn = getConn();

            // 执行更新或删除
            PreparedStatement ps = conn.prepareCall("{call "+procName+"()}");
            boolean flag = ps.execute();
            return flag;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("更新失败");
        }finally {
            closeConn();
        }

        return false;
    }
}
