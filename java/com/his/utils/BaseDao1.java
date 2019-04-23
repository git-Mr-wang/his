package com.qhit.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sun.org.glassfish.gmbal.Description;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;


/**
 * Created by Administrator on 2018/7/25 0025.
 */
/**
 * 多表根据sql语句自动生成mapper文件
 */
public class BaseDao1 {

    //需要生成mapper文件的sql语句
    private static String sql = "SELECT * FROM patient_register_record prr \n" +
            "\t\tJOIN base_patient_info bpi ON prr.patient_id=bpi.patient_id\n" +
            "\t\tWHERE STATUS=1 AND doctor_id=14\n" +
            "UNION\n" +
            "SELECT * FROM patient_register_record prr \n" +
            "\t\tJOIN base_patient_info bpi ON prr.patient_id=bpi.patient_id\n" +
            "\t\tWHERE prr.doctor_id IS NULL";
    //主表
    private static String mainTable = "patient_register_record";

    private static ComboPooledDataSource comboPooledDataSource = null;
    static {
        comboPooledDataSource = new ComboPooledDataSource();
    }

    public static Connection conn = null;
    public static ResultSet set = null;
    public static PreparedStatement ps =null;
    public static void main(String[] args) throws IOException {
        //文件输出位置
        File dir = new File("C:\\F\\codeout\\generateMapper.xml");
        //字节输出流
        BufferedWriter mapperWriter= new BufferedWriter(new FileWriter(dir));
        try {
            // 获取连接
            Connection conn = getConn();
            // 获取执行对象
            ps = conn.prepareStatement(sql);
            //得到表名和字段列表组成的Map集合
            Map<String,Set<String>> tableColumnes = new HashMap<>();
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            while(rs.next()){
                int count = metaData.getColumnCount();
                for (int i = 1; i <=count ; i++) {
                    String table = metaData.getTableName(i);
                    if(table==null||"".equals(table)){
                        table = mainTable;
                    }
                    Set l = tableColumnes.get(table);
                    if(l==null){
                        l = new HashSet<String>();
                        tableColumnes.put(table,l);
                    }else{
                        String columnName = metaData.getColumnName(i);
                        l.add(columnName);
                    }

                }
            }
//            根据map生成mapper文件
//            buffer用于定义整个mapper文件
            StringBuffer buffer = new StringBuffer();
            String javaBeanName = dbTableToJavaBean(mainTable);
            String javaPackageName = toLowerCaseFirstOne(javaBeanName);
            buffer.append("\t<resultMap id=\""+javaPackageName+"ResultMap\" type=\"com.qhit."+javaPackageName+".pojo."+javaBeanName+"\"> \r\n");
            buffer.append("\t</resultMap>\r\n");
//            遍历map
//            主表
            for (String tableName:tableColumnes.keySet()){
                if(mainTable.equals(tableName)){
                    for(String col:tableColumnes.get(tableName)){
                        buffer.insert(buffer.indexOf("\t</resultMap>"),"\t\t<result property=\""+dbColsToJavaCols(col)+"\" column=\""+col+"\"></result>\r\n");
                    }
                }
            }
//            不是主表
            for (String tableName:tableColumnes.keySet()){
                if(!mainTable.equals(tableName)){
                    StringBuffer associationBuffer = new StringBuffer();
                    String beanName = dbTableToJavaBean(tableName);
                    String packageName = toLowerCaseFirstOne(beanName);
                    associationBuffer.append("\t\t<association property=\""+packageName+"\" javaType=\"com.qhit."+packageName+".pojo."+beanName+"\"> \r\n");
                    associationBuffer.append("\t\t</association>\r\n");
                    for(String col:tableColumnes.get(tableName)){
                        associationBuffer.insert(associationBuffer.indexOf("\t\t</association>"),"\t\t\t<result property=\""+dbColsToJavaCols(col)+"\" column=\""+col+"\"></result>\r\n");
                    }
//                    插入association配置
                    buffer.insert(buffer.indexOf("\t</resultMap>"),associationBuffer);
                }
            }
            mapperWriter.write(buffer.toString());
            mapperWriter.close();
            System.out.println("执行成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("生成失败");
        }finally {
            closeConn();
        }

    }





    /**
     * 获取连接
     * @return
     */

    public   static  Connection getConn(){
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
    public static void closeConn(){
        if(set!=null) set=null;
        if(ps!=null) ps=null;
        if(conn!=null) try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

}
