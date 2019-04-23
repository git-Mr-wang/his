package com.qhit.utils;

/**
 * Created by Administrator on 2018/7/25 0025.
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 根据表名，自动生成javabean,dao,dao实现类,service,service实现类
 *
 * Version 1.4
 *
 * 1 自动生成代码增加了controller和jsp
 * 2 数据库中，属性名允许大写
 *
 */
public class GenerateCodeOld {

    private static String tableName = "medicine_stockinfo";
    private static String tableChineseName = "";
    private static String javaBeanName = BaseDao.dbTableToJavaBean(tableName);
    private static String javaPackageName = BaseDao.toLowerCaseFirstOne(javaBeanName);
    private static BaseDao dao = new BaseDao();

    public static void main(String[] args) throws Exception {

        //连接
        Connection conn = dao.getConn();
        String sql = "select * from "+tableName;
        sql=sql.toLowerCase();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        //元数据
        ResultSetMetaData metaData = rs.getMetaData();
        rs.close();
        //字段注释
        String[] comments = findComments(conn, metaData);
        //文件输出位置
        File dir = new File("C:\\F\\codeout");
        if(!dir.exists()){
            dir.mkdirs();
        }
        //删除文件夹下的所有文件
        delAllFile(dir.getAbsolutePath());
        //创建 pojo dao service 文件夹
        makeSomeDirs(dir);


        //javabean
        String beanName = javaBeanName+".java";
        BufferedWriter beanWriter = new BufferedWriter(new FileWriter(dir.getAbsolutePath()+"\\com\\qhit\\"+javaPackageName+"\\pojo\\"+beanName));
        //dao
        String daoName = "I"+javaBeanName+"Dao.java";
        BufferedWriter daoWriter= new BufferedWriter(new FileWriter(dir.getAbsolutePath()+"\\com\\qhit\\"+javaPackageName+"\\dao\\"+daoName));
        //dao实现类
        String daoImplName = javaBeanName+"DaoImpl.java";
        BufferedWriter daoImplWriter= new BufferedWriter(new FileWriter(dir.getAbsolutePath()+"\\com\\qhit\\"+javaPackageName+"\\dao\\impl\\"+daoImplName));
        //service
        String serviceName = "I"+javaBeanName+"Service.java";
        BufferedWriter serviceWriter= new BufferedWriter(new FileWriter(dir.getAbsolutePath()+"\\com\\qhit\\"+javaPackageName+"\\service\\"+serviceName));
        //service实现类
        String serviceImplName = javaBeanName+"ServiceImpl.java";
        BufferedWriter serviceImplWriter= new BufferedWriter(new FileWriter(dir.getAbsolutePath()+"\\com\\qhit\\"+javaPackageName+"\\service\\impl\\"+serviceImplName));

        //Controller
        String controllerName = javaBeanName+"Controller.java";
        BufferedWriter controllerWriter = new BufferedWriter(new FileWriter(dir.getAbsolutePath()+"\\com\\qhit\\"+javaPackageName+"\\controller\\"+controllerName));
        //list.jsp
        String listJspName = "list.jsp";
        BufferedWriter listJspWriter = new BufferedWriter(new FileWriter(dir.getAbsolutePath()+"\\jsp\\"+javaPackageName+"\\"+listJspName));
        //add.jsp
        String addJspName = "add.jsp";
        BufferedWriter addJspWriter = new BufferedWriter(new FileWriter(dir.getAbsolutePath()+"\\jsp\\"+javaPackageName+"\\"+addJspName));
        //edit.jsp
        String editJspName = "edit.jsp";
        BufferedWriter editJspWriter = new BufferedWriter(new FileWriter(dir.getAbsolutePath()+"\\jsp\\"+javaPackageName+"\\"+editJspName));


        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        String now = format.format(date);

        // dao
        generateDao(metaData,javaBeanName, daoWriter, now);
        //dao实现类
        generateDaoImpl(metaData,javaBeanName, daoImplWriter, now);
        //javabean
        generateJavaBean(metaData, javaBeanName, beanWriter, now,comments);
        // service
        generateService(metaData,javaBeanName, serviceWriter, now);
        //dao实现类
        generateServiceImpl(metaData,javaBeanName, serviceImplWriter, now);

        //controller
        generateController(metaData,javaBeanName, controllerWriter, now);
        //list.jsp
        generateListJsp(metaData,javaBeanName, listJspWriter, now,comments);
        //add.jsp
        generateAddJsp(metaData,javaBeanName, addJspWriter, now,comments);
        //edit.jsp
        generateEditJsp(metaData,javaBeanName, editJspWriter, now,comments);

        System.out.println("执行成功");

    }

    private static void generateEditJsp(ResultSetMetaData metaData, String javaBeanName, BufferedWriter editJspWriter, String now, String[] comments) throws IOException, SQLException {
        editJspWriter.write("<%-- \r\n");
        editJspWriter.write("  Created by IntelliJ IDEA. \r\n");
        editJspWriter.write("  "+now+" \r\n");
        editJspWriter.write("  To change this template use File | Settings | File Templates. \r\n");
        editJspWriter.write("--%> \r\n");
        editJspWriter.write("<%@ page contentType=\"text/html;charset=UTF-8\" language=\"java\" %> \r\n");
        editJspWriter.write("<%@include file=\"/common/common.jsp\"%> \r\n");
        editJspWriter.write("<html> \r\n");
        editJspWriter.write("<head> \r\n");
        editJspWriter.write("    <title>Title</title>\r\n");
        editJspWriter.write("</head> \r\n");
        editJspWriter.newLine();
        //主键
        String primarykey = metaData.getColumnName(1);
        String priName = BaseDao.dbColsToJavaCols(primarykey);
        editJspWriter.write("<body class=\"main\"> \r\n");
        editJspWriter.write("<form action=\"${path}/"+javaPackageName+"/update.action\"> \r\n");
        editJspWriter.write("    <h1>修改"+tableChineseName+"</h1> \r\n");
        editJspWriter.write("    <input type=\"hidden\" name=\""+priName+"\" value=\"${"+javaPackageName+"."+priName+"}\"> \r\n");
        editJspWriter.write("    <div class=\"update\"> \r\n");
        int count = metaData.getColumnCount();
        for(int i=2;i<=count;i++){
            String columnName = metaData.getColumnName(i);
            String javaCol = BaseDao.dbColsToJavaCols(columnName);
            //列类型 大写
            String type = metaData.getColumnTypeName(i);
            if(i%2==0){
                editJspWriter.write("        <div class=\"left\"> \r\n");
            }else{
                editJspWriter.write("        <div class=\"right\"> \r\n");
            }
            editJspWriter.write("            <span>"+comments[i-1]+"</span> \r\n");
            if ("DATE".equals(type) || "DATETIME".equals(type) || "TIMESTAMP".equals(type)){
                editJspWriter.write("            <input type=\"date\" name=\""+javaCol+"\" value=\"${"+javaPackageName+"."+javaCol+"}\"> \r\n");
            }else{
                editJspWriter.write("            <input type=\"text\" name=\""+javaCol+"\" value=\"${"+javaPackageName+"."+javaCol+"}\"> \r\n");
            }
            editJspWriter.write("        </div> \r\n");
        }
        //字段格式是偶数个 后面加上一个空的div 为了好看
        if(count%2==0){
            editJspWriter.write("        <div class=\"right\"> \r\n");
            editJspWriter.write("        </div> \r\n");
        }
        editJspWriter.write("        <div id=\"error\"></div> \r\n");
        editJspWriter.write("        <div class=\"buttons\"> \r\n");
        editJspWriter.write("            <input type=\"submit\" value=\"提交\"> \r\n");
        editJspWriter.write("            <input type=\"button\" onclick=\"history.back()\" value=\"返回\"> \r\n");
        editJspWriter.write("        </div> \r\n");
        editJspWriter.write("    </div> \r\n");
        editJspWriter.write("</form> \r\n");
        editJspWriter.write("</body> \r\n");
        editJspWriter.write("</html> \r\n");
        editJspWriter.write(" \r\n");
        //关流
        editJspWriter.close();
    }

    private static void generateAddJsp(ResultSetMetaData metaData, String javaBeanName, BufferedWriter addJspWriter, String now, String[] comments) throws IOException, SQLException {
        addJspWriter.write("<%-- \r\n");
        addJspWriter.write("  Created by IntelliJ IDEA. \r\n");
        addJspWriter.write("  "+now+" \r\n");
        addJspWriter.write("  To change this template use File | Settings | File Templates. \r\n");
        addJspWriter.write("--%> \r\n");
        addJspWriter.write("<%@ page contentType=\"text/html;charset=UTF-8\" language=\"java\" %> \r\n");
        addJspWriter.write("<%@include file=\"/common/common.jsp\"%> \r\n");
        addJspWriter.write("<html> \r\n");
        addJspWriter.write("<head> \r\n");
        addJspWriter.write("    <title>Title</title>\r\n");
        addJspWriter.write("</head> \r\n");
        addJspWriter.newLine();

        addJspWriter.write("<body class=\"main\"> \r\n");
        addJspWriter.write("<form action=\"${path}/"+javaPackageName+"/insert.action\"> \r\n");
        addJspWriter.write("    <h1>添加"+tableChineseName+"</h1> \r\n");
        addJspWriter.write("    <div class=\"update\"> \r\n");
        int count = metaData.getColumnCount();
        for(int i=2;i<=count;i++){
            String columnName = metaData.getColumnName(i);
            String javaCol = BaseDao.dbColsToJavaCols(columnName);
            //列类型 大写
            String type = metaData.getColumnTypeName(i);
            if(i%2==0){
                addJspWriter.write("        <div class=\"left\"> \r\n");
            }else{
                addJspWriter.write("        <div class=\"right\"> \r\n");
            }
            addJspWriter.write("            <span>"+comments[i-1]+"</span> \r\n");
            if ("DATE".equals(type) || "DATETIME".equals(type) || "TIMESTAMP".equals(type)){
                addJspWriter.write("            <input type=\"date\" name=\""+javaCol+"\" value=\"\"> \r\n");
            }else{
                addJspWriter.write("            <input type=\"text\" name=\""+javaCol+"\" value=\"\"> \r\n");
            }
            addJspWriter.write("        </div> \r\n");
        }
        //字段格式是偶数个 后面加上一个空的div 为了好看
        if(count%2==0){
            addJspWriter.write("        <div class=\"right\"> \r\n");
            addJspWriter.write("        </div> \r\n");
        }
        addJspWriter.write("        <div id=\"error\"></div> \r\n");
        addJspWriter.write("        <div class=\"buttons\"> \r\n");
        addJspWriter.write("            <input type=\"submit\" value=\"提交\"> \r\n");
        addJspWriter.write("            <input type=\"button\" onclick=\"history.back()\" value=\"返回\"> \r\n");
        addJspWriter.write("        </div> \r\n");
        addJspWriter.write("    </div> \r\n");
        addJspWriter.write("</form> \r\n");
        addJspWriter.write("</body> \r\n");
        addJspWriter.write("</html> \r\n");
        addJspWriter.write(" \r\n");
        //关流
        addJspWriter.close();
    }

    private static void generateListJsp(ResultSetMetaData metaData, String javaBeanName, BufferedWriter listJspWriter, String now, String[] comments) throws IOException, SQLException {
        //主键
        String pName = metaData.getColumnName(1);
        String priName = BaseDao.dbColsToJavaCols(pName);
        String searchColName = metaData.getColumnName(2);
        String searchName = BaseDao.dbColsToJavaCols(searchColName);
        String searchCommentName = comments[1];
        int count = metaData.getColumnCount();
        // 第二个字段 一般是名字 作为查询条件用于参考
        listJspWriter.write("<%-- \r\n");
        listJspWriter.write("  Created by IntelliJ IDEA. \r\n");
        listJspWriter.write("  "+now+" \r\n");
        listJspWriter.write("  To change this template use File | Settings | File Templates. \r\n");
        listJspWriter.write("--%> \r\n");
        listJspWriter.write("<%@ page contentType=\"text/html;charset=UTF-8\" language=\"java\" %> \r\n");
        listJspWriter.write("<%@include file=\"/common/common.jsp\"%> \r\n");
        listJspWriter.write("<html> \r\n");
        listJspWriter.write("<head> \r\n");
        listJspWriter.write("    <script type=\"text/javascript\"> \r\n");
        listJspWriter.write("        $(function () { \r\n");
        listJspWriter.write("            $(\"#addBtn\").click(function () { \r\n");
        listJspWriter.write("                location.href=\"${path}/jsp/"+javaPackageName+"/add.jsp\";\r\n");
        listJspWriter.write("             })\r\n");
        listJspWriter.write("            $(\".update\").click(function () { \r\n");
        listJspWriter.write("                var "+priName+" = $(this).attr(\"name\");\r\n");
        listJspWriter.write("                location.href=\"${path}/"+javaPackageName+"/load.action?"+priName+"=\"+"+priName+";\r\n");
        listJspWriter.write("             })\r\n");
        listJspWriter.write("            $(\".delete\").click(function () { \r\n");
        listJspWriter.write("                var "+priName+" = $(this).attr(\"name\");\r\n");
        listJspWriter.write("                location.href=\"${path}/"+javaPackageName+"/delete.action?"+priName+"=\"+"+priName+";\r\n");
        listJspWriter.write("             })\r\n");
        listJspWriter.write("            $(\"#search\").click(function () { \r\n");
        listJspWriter.write("                var "+searchName+" = $(\"#"+searchName+"\").val();\r\n");
        listJspWriter.write("                location.href = \"${path}/"+javaPackageName+"/search.action?"+searchName+"=\"+"+searchName+";\r\n");
        listJspWriter.write("             })\r\n");
        listJspWriter.write("        })  \r\n");
        listJspWriter.write("    </script> \r\n");
        listJspWriter.write("</head> \r\n");
        listJspWriter.write("<body class=\"main\"> \r\n");

        listJspWriter.write("    <div class=\"search\"> \r\n");
        listJspWriter.write("        <span> \r\n");
        listJspWriter.write("            "+searchCommentName+"：<input type=\"text\" id=\""+searchName+"\" value=\"${searchObject."+searchName+"}\"> \r\n");
        listJspWriter.write("        </span> \r\n");
        listJspWriter.write("        <span> \r\n");
        listJspWriter.write("            <button id=\"search\">查询</button> \r\n");
        listJspWriter.write("        </span> \r\n");
        listJspWriter.write("        <span> \r\n");
        listJspWriter.write("            <button id=\"addBtn\">增加</button> \r\n");
        listJspWriter.write("        </span> \r\n");
        listJspWriter.write("    </div> \r\n" );


        listJspWriter.write("    <table> \r\n");
        listJspWriter.write("        <thead> \r\n");
        listJspWriter.write("            <td>序号</td> \r\n");
        for(int i=1;i<comments.length;i++){
            listJspWriter.write("            <td>"+comments[i]+"</td> \r\n");
        }
        listJspWriter.write("            <td>编辑</td> \r\n");
        listJspWriter.write("            <td>删除</td> \r\n");
        listJspWriter.write("        </thead> \r\n");
        listJspWriter.write("        <c:forEach items=\"${list}\" var=\""+javaPackageName+"\" varStatus=\"status\"> \r\n");
        listJspWriter.write("            <tr> \r\n");
        listJspWriter.write("                <td>${status.index+1}</td> \r\n");
        for(int i=2;i<=count;i++){
            String columnName = metaData.getColumnName(i);
            String javaCol = BaseDao.dbColsToJavaCols(columnName);
            listJspWriter.write("                <td>${"+javaPackageName+"."+javaCol+"}</td> \r\n");
        }
        listJspWriter.write("                <td><img src=\"${path}/images/edit.gif\" class=\"update\" name=\"${"+javaPackageName+"."+priName+"}\"></td> \r\n");
        listJspWriter.write("                <td><img src=\"${path}/images/del.gif\" class=\"delete\" name=\"${"+javaPackageName+"."+priName+"}\"></td> \r\n");
        listJspWriter.write("            </tr> \r\n");
        listJspWriter.write("        </c:forEach> \r\n");
        listJspWriter.write("    </table> \r\n");
        listJspWriter.write("</body> \r\n");
        listJspWriter.write("</html> \r\n");
        //关流
        listJspWriter.close();

    }


    private static void generateController(ResultSetMetaData metaData, String javaBeanName, BufferedWriter controllerWriter, String now) throws IOException, SQLException {
        controllerWriter.write("package com.qhit."+javaPackageName+".controller; \r\n");
        controllerWriter.newLine();
        controllerWriter.write("import com.qhit."+javaPackageName+".pojo."+javaBeanName+"; \r\n");
        controllerWriter.write("import com.qhit."+javaPackageName+".service.I"+javaBeanName+"Service; \r\n");
        controllerWriter.write("import com.qhit."+javaPackageName+".service.impl."+javaBeanName+"ServiceImpl; \r\n");
        controllerWriter.write("import org.springframework.stereotype.Controller; \r\n");
        controllerWriter.write("import org.springframework.ui.Model; \r\n");
        controllerWriter.write("import org.springframework.web.bind.annotation.RequestMapping; \r\n");
        controllerWriter.write("import javax.annotation.Resource; \r\n");
        controllerWriter.write("import javax.servlet.http.HttpServletRequest; \r\n");
        controllerWriter.write("import javax.servlet.http.HttpServletResponse; \r\n");
        controllerWriter.write("import com.alibaba.fastjson.JSON; \r\n");
        controllerWriter.write("import java.io.IOException; \r\n");
        controllerWriter.write("import java.util.List; \r\n");
        controllerWriter.newLine();
        controllerWriter.write("/**");
        controllerWriter.newLine();
        controllerWriter.write("* Created by GeneratorCode on "+now);
        controllerWriter.newLine();
        controllerWriter.write("*/");
        controllerWriter.newLine();
        controllerWriter.write("@Controller \r\n");
        controllerWriter.write("@RequestMapping(\"/"+javaPackageName+"\") \r\n");
        controllerWriter.write("public class "+javaBeanName+"Controller { \r\n");
        controllerWriter.newLine();
        controllerWriter.write("    I"+javaBeanName+"Service "+javaPackageName+"Service = new "+javaBeanName+"ServiceImpl();; \r\n");
        controllerWriter.newLine();
        controllerWriter.write("    @RequestMapping(\"/insert\") \r\n");
        controllerWriter.write("    public String insert("+javaBeanName+" "+javaPackageName+") { \r\n");
        controllerWriter.write("        "+javaPackageName+"Service.insert("+javaPackageName+"); \r\n");
        controllerWriter.write("        return \"forward:list.action\"; \r\n");
        controllerWriter.write("    } \r\n");
        controllerWriter.write(" \r\n");
        controllerWriter.write("    @RequestMapping(\"/delete\") \r\n");
        //主键
        String primarykey = metaData.getColumnName(1);
        String priName = BaseDao.dbColsToJavaCols(primarykey);
        controllerWriter.write("    public String delete(Integer "+priName+", HttpServletResponse response) throws IOException { \r\n");
        controllerWriter.write("        "+javaPackageName+"Service.delete("+priName+"); \r\n");
        controllerWriter.write("        return \"forward:list.action\"; \r\n");
        controllerWriter.write("    } \r\n");
        controllerWriter.write(" \r\n");
        controllerWriter.write("    @RequestMapping(\"/update\") \r\n");
        controllerWriter.write("    public String update("+javaBeanName+" "+javaPackageName+") { \r\n");
        controllerWriter.write("        "+javaPackageName+"Service.update("+javaPackageName+"); \r\n");
        controllerWriter.write("        return \"forward:list.action\"; \r\n");
        controllerWriter.write("    } \r\n");
        controllerWriter.write(" \r\n");
        controllerWriter.write("    @RequestMapping(\"/updateSelective\") \r\n");
        controllerWriter.write("    public String updateSelective("+javaBeanName+" "+javaPackageName+") { \r\n");
        controllerWriter.write("        "+javaPackageName+"Service.updateSelective("+javaPackageName+"); \r\n");
        controllerWriter.write("        return \"forward:list.action\"; \r\n");
        controllerWriter.write("    } \r\n");
        controllerWriter.write(" \r\n");
        controllerWriter.write("    @RequestMapping(\"/load\") \r\n");
        controllerWriter.write("    public String load(Integer "+priName+", Model model) { \r\n");
        controllerWriter.write("        "+javaBeanName+" "+javaPackageName+" = "+javaPackageName+"Service.findById("+priName+"); \r\n");
        controllerWriter.write("        model.addAttribute(\""+javaPackageName+"\","+javaPackageName+"); \r\n");
        controllerWriter.write("        return \""+javaPackageName+"/edit\"; \r\n");
        controllerWriter.write("    } \r\n");
        controllerWriter.write(" \r\n");
        controllerWriter.write("    @RequestMapping(\"/list\") \r\n");
        controllerWriter.write("    public String list(Model model) throws IOException { \r\n");
        controllerWriter.write("        List<"+javaBeanName+"> list = "+javaPackageName+"Service.findAll(); \r\n");
        controllerWriter.write("        model.addAttribute(\"list\",list); \r\n");
        controllerWriter.write("        return \""+javaPackageName+"/list\"; \r\n");
        controllerWriter.write("    } \r\n");
        controllerWriter.write(" \r\n");
        controllerWriter.write("    @RequestMapping(\"/ajaxList\") \r\n");
        controllerWriter.write("    public void ajaxList(HttpServletResponse response) throws IOException { \r\n");
        controllerWriter.write("        List<"+javaBeanName+"> list = "+javaPackageName+"Service.findAll(); \r\n");
        controllerWriter.write("        String s = JSON.toJSONString(list); \r\n");
        controllerWriter.write("        response.getWriter().write(s); \r\n");
        controllerWriter.write("    } \r\n");
        controllerWriter.write(" \r\n");
        controllerWriter.write("    @RequestMapping(\"/search\") \r\n");
        controllerWriter.write("    public String search("+javaBeanName+" "+javaPackageName+",Model model) { \r\n");
        controllerWriter.write("        List<"+javaBeanName+"> list = "+javaPackageName+"Service.search("+javaPackageName+"); \r\n");
        controllerWriter.write("        model.addAttribute(\"list\",list); \r\n");
        controllerWriter.write("        model.addAttribute(\"searchObject\","+javaPackageName+"); \r\n");
        controllerWriter.write("        return \""+javaPackageName+"/list\"; \r\n");
        controllerWriter.write("    } \r\n");
        controllerWriter.write(" \r\n");
        controllerWriter.write("} \r\n");
        // 关流
        controllerWriter.close();
    }



    private static void generateJavaBean(ResultSetMetaData metaData, String javaBeanName, BufferedWriter beanWriter, String now,String[] comments) throws IOException, SQLException {
        //javabean写头部
        beanWriter.write("package com.qhit."+javaPackageName+".pojo;");
        beanWriter.newLine();
        beanWriter.newLine();
        beanWriter.newLine();
        beanWriter.write("/**");
        beanWriter.newLine();
        beanWriter.write("* Created by GeneratorCode on "+now);
        beanWriter.newLine();
        beanWriter.write("*/");
        beanWriter.newLine();
        beanWriter.newLine();
        beanWriter.write("public class "+javaBeanName+" {");
        beanWriter.newLine();
        beanWriter.newLine();
        //存储get,set方法
        StringBuffer buffer = new StringBuffer("\r\n");
        int count = metaData.getColumnCount();
        for(int i=1;i<=count;i++){
            //列名 小写
            String columnName = metaData.getColumnName(i);
            String javaCol = BaseDao.dbColsToJavaCols(columnName);
            String upperCaseColumnName = dao.toUpperCaseFirstOne(javaCol);
            //列类型 大写
            String type = metaData.getColumnTypeName(i);
            if(type.equals("VARCHAR")||type.equals("VARCHAR2")||type.equals("TIME")||type.equals("DATE")||type.equals("DATETIME")||type.equals("TIMESTAMP")){
                beanWriter.write("    private String "+javaCol+";    //"+comments[i-1]);
                beanWriter.newLine();

                buffer.append("    public String get"+upperCaseColumnName+"() { \r\n");
                buffer.append("        return "+javaCol+";\r\n");
                buffer.append("    }\r\n \r\n");
                buffer.append("    public void set"+upperCaseColumnName+"(String "+javaCol+") { \r\n");
                buffer.append("        this."+javaCol+" = "+javaCol+";\r\n");
                buffer.append("    }\r\n \r\n");

            }else if(type.equals("INT")){
                beanWriter.write("    private Integer "+javaCol+";    //"+comments[i-1]);
                beanWriter.newLine();

                buffer.append("    public Integer get"+upperCaseColumnName+"() { \r\n");
                buffer.append("        return "+javaCol+";\r\n");
                buffer.append("    }\r\n \r\n");
                buffer.append("    public void set"+upperCaseColumnName+"(Integer "+javaCol+") { \r\n");
                buffer.append("        this."+javaCol+" = "+javaCol+";\r\n");
                buffer.append("    }\r\n \r\n");
            }else if(type.equals("FLOAT")){
                beanWriter.write("    private Float "+javaCol+";    //"+comments[i-1]);
                beanWriter.newLine();

                buffer.append("    public Float get"+upperCaseColumnName+"() { \r\n");
                buffer.append("        return "+javaCol+";\r\n");
                buffer.append("    }\r\n \r\n");
                buffer.append("    public void set"+upperCaseColumnName+"(Float "+javaCol+") { \r\n");
                buffer.append("        this."+javaCol+" = "+javaCol+";\r\n");
                buffer.append("    }\r\n \r\n");
            }else if(type.equals("DOUBLE")){
                beanWriter.write("    private Double "+javaCol+";    //"+comments[i-1]);
                beanWriter.newLine();

                buffer.append("    public Double get"+upperCaseColumnName+"() { \r\n");
                buffer.append("        return "+javaCol+";\r\n");
                buffer.append("    }\r\n \r\n");
                buffer.append("    public void set"+upperCaseColumnName+"(Double "+javaCol+") { \r\n");
                buffer.append("        this."+javaCol+" = "+javaCol+";\r\n");
                buffer.append("    }\r\n \r\n");
            }
        }
        beanWriter.write(buffer.toString()+"\r\n }");
        //关流
        beanWriter.close();
    }

    private static void generateDaoImpl(ResultSetMetaData metaData,String javaBeanName, BufferedWriter daoImplWriter, String now) throws IOException, SQLException {
        daoImplWriter.write("package com.qhit."+javaPackageName+".dao.impl;");
        daoImplWriter.newLine();
        daoImplWriter.newLine();
        daoImplWriter.write("import com.qhit."+javaPackageName+".dao.I"+javaBeanName+"Dao;");
        daoImplWriter.newLine();
        daoImplWriter.write("import com.qhit.utils.BaseDao;");
        daoImplWriter.newLine();
        daoImplWriter.write("import java.util.List;");
        daoImplWriter.newLine();
        daoImplWriter.newLine();
        daoImplWriter.write("/**");
        daoImplWriter.newLine();
        daoImplWriter.write("* Created by GeneratorCode on "+now);
        daoImplWriter.newLine();
        daoImplWriter.write("*/");
        daoImplWriter.newLine();
        daoImplWriter.newLine();
        daoImplWriter.write("public class "+javaBeanName+"DaoImpl extends BaseDao implements I"+javaBeanName+"Dao {");
        daoImplWriter.newLine();
        daoImplWriter.newLine();
        daoImplWriter.write("    @Override \r\n");
        daoImplWriter.write("    public List findAll() { \r\n");
        daoImplWriter.write("        String sql = \"select * from "+tableName+"\"; \r\n");
        daoImplWriter.write("        return freeFind(sql); \r\n");
        daoImplWriter.write("    } \r\n");
        daoImplWriter.newLine();
        daoImplWriter.newLine();
        int count = metaData.getColumnCount();
        for(int i=1;i<=count;i++) {
            //列名 小写
            String columnName = metaData.getColumnName(i);
            String javaCol = BaseDao.dbColsToJavaCols(columnName);
            String upperCaseColumnName = dao.toUpperCaseFirstOne(javaCol);
            if(i==1){
                //主键
                daoImplWriter.write("    @Override \r\n");
                daoImplWriter.write("    public List findById(Object id) { \r\n");
                daoImplWriter.write("        String sql = \"select * from "+tableName+" where "+columnName+"='\"+id+\"'\"; \r\n");
                daoImplWriter.write("        return freeFind(sql); \r\n");
                daoImplWriter.write("    } \r\n");
                daoImplWriter.newLine();
                daoImplWriter.newLine();
            }else{
                daoImplWriter.write("    @Override \r\n");
                daoImplWriter.write("    public List findBy"+upperCaseColumnName+"(Object "+javaCol+") { \r\n");
                daoImplWriter.write("        String sql = \"select * from "+tableName+" where "+columnName+"='\"+"+javaCol+"+\"'\"; \r\n");
                daoImplWriter.write("        return freeFind(sql); \r\n");
                daoImplWriter.write("    } \r\n");
                daoImplWriter.newLine();
                daoImplWriter.newLine();
            }
        }

        daoImplWriter.newLine();
        daoImplWriter.newLine();
        daoImplWriter.write("}");
        daoImplWriter.close();
    }

    /**
     * Dao模板
     * @param javaBeanName
     * @param daoWriter
     * @param now
     * @throws IOException
     */
    private static void generateDao(ResultSetMetaData metaData,String javaBeanName, BufferedWriter daoWriter, String now) throws IOException, SQLException {
        daoWriter.write("package com.qhit."+javaPackageName+".dao;");
        daoWriter.newLine();
        daoWriter.newLine();
        daoWriter.write("import com.qhit.utils.BaseDao;");
        daoWriter.newLine();
        daoWriter.write("import java.util.List;");
        daoWriter.newLine();
        daoWriter.newLine();
        daoWriter.write("/**");
        daoWriter.newLine();
        daoWriter.write("* Created by GeneratorCode on "+now);
        daoWriter.newLine();
        daoWriter.write("*/");
        daoWriter.newLine();
        daoWriter.newLine();
        daoWriter.write("public interface I"+javaBeanName+"Dao {");
        daoWriter.newLine();
        daoWriter.newLine();
        daoWriter.write("    boolean insert(Object object);");
        daoWriter.newLine();
        daoWriter.newLine();
        daoWriter.write("    boolean  update(Object object);");
        daoWriter.newLine();
        daoWriter.newLine();
        daoWriter.write("    boolean  updateSelective(Object object);");
        daoWriter.newLine();
        daoWriter.newLine();
        daoWriter.write("    boolean delete(Object object);");
        daoWriter.newLine();
        daoWriter.newLine();
        daoWriter.write("    List freeFind(String sql);");
        daoWriter.newLine();
        daoWriter.newLine();
        daoWriter.write("    List findAll();");
        daoWriter.newLine();
        daoWriter.newLine();
        daoWriter.write("    List findById(Object id);");
        daoWriter.newLine();
        daoWriter.newLine();
        daoWriter.write("    boolean freeUpdate(String sql);");
        daoWriter.newLine();
        daoWriter.newLine();
        int count = metaData.getColumnCount();
        for(int i=2;i<=count;i++) {
            //列名 小写
            String columnName = metaData.getColumnName(i);
            String javaCol = BaseDao.dbColsToJavaCols(columnName);
            String upperCaseColumnName = dao.toUpperCaseFirstOne(javaCol);
            daoWriter.write("    List findBy"+upperCaseColumnName+"(Object "+javaCol+");");
            daoWriter.newLine();
            daoWriter.newLine();
        }
        daoWriter.write("}");
        daoWriter.close();
    }

    private static void generateServiceImpl(ResultSetMetaData metaData,String javaBeanName, BufferedWriter serviceImplWriter, String now) throws IOException, SQLException {
        serviceImplWriter.write("package com.qhit."+javaPackageName+".service.impl;");
        serviceImplWriter.newLine();
        serviceImplWriter.newLine();
        serviceImplWriter.write("import com.qhit."+javaPackageName+".service.I"+javaBeanName+"Service;");
        serviceImplWriter.newLine();
        serviceImplWriter.write("import java.util.List;");
        serviceImplWriter.newLine();
        serviceImplWriter.write("import com.qhit."+javaPackageName+".dao.I"+javaBeanName+"Dao;");
        serviceImplWriter.newLine();
        serviceImplWriter.write("import com.qhit."+javaPackageName+".dao.impl."+javaBeanName+"DaoImpl;");
        serviceImplWriter.newLine();
        serviceImplWriter.write("import com.qhit."+javaPackageName+".pojo."+javaBeanName+";\r\n");
        serviceImplWriter.newLine();
        serviceImplWriter.write("/**");
        serviceImplWriter.newLine();
        serviceImplWriter.write("* Created by GeneratorCode on "+now);
        serviceImplWriter.newLine();
        serviceImplWriter.write("*/");
        serviceImplWriter.newLine();
        serviceImplWriter.newLine();
        serviceImplWriter.write("public class "+javaBeanName+"ServiceImpl  implements I"+javaBeanName+"Service {");
        serviceImplWriter.newLine();
        serviceImplWriter.newLine();
        serviceImplWriter.write("    I"+javaBeanName+"Dao dao = new "+javaBeanName+"DaoImpl();");
        serviceImplWriter.newLine();
        serviceImplWriter.newLine();
        serviceImplWriter.write("    @Override \r\n");
        serviceImplWriter.write("    public boolean insert(Object object) { \r\n");
        serviceImplWriter.write("        return dao.insert(object); \r\n");
        serviceImplWriter.write("    } \r\n");
        serviceImplWriter.newLine();
        serviceImplWriter.newLine();
        serviceImplWriter.write("    @Override \r\n");
        serviceImplWriter.write("    public boolean update(Object object) { \r\n");
        serviceImplWriter.write("        return dao.update(object); \r\n");
        serviceImplWriter.write("    } \r\n");
        serviceImplWriter.newLine();
        serviceImplWriter.newLine();
        serviceImplWriter.write("    @Override \r\n");
        serviceImplWriter.write("    public boolean updateSelective(Object object) { \r\n");
        serviceImplWriter.write("        return dao.updateSelective(object); \r\n");
        serviceImplWriter.write("    } \r\n");
        serviceImplWriter.newLine();
        serviceImplWriter.newLine();
        serviceImplWriter.write("    @Override \r\n");
        serviceImplWriter.write("    public boolean delete(Object id) { \r\n");
        serviceImplWriter.write("        "+javaBeanName+" "+javaPackageName+" = findById(id); \r\n");
        serviceImplWriter.write("        return dao.delete("+javaPackageName+"); \r\n");
        serviceImplWriter.write("    } \r\n");
        serviceImplWriter.newLine();
        serviceImplWriter.newLine();
        serviceImplWriter.write("    @Override \r\n");
        serviceImplWriter.write("    public List findAll() { \r\n");
        serviceImplWriter.write("        return dao.findAll(); \r\n");
        serviceImplWriter.write("    } \r\n");
        serviceImplWriter.newLine();
        serviceImplWriter.newLine();
        serviceImplWriter.write("    @Override \r\n");
        serviceImplWriter.write("    public "+javaBeanName+" findById(Object id) { \r\n");
        serviceImplWriter.write("        List<"+javaBeanName+"> list = dao.findById(id); \r\n");
        serviceImplWriter.write("        return  list.get(0); \r\n");
        serviceImplWriter.write("    } \r\n");
        serviceImplWriter.newLine();
        serviceImplWriter.newLine();
        serviceImplWriter.write("    @Override \r\n");
        serviceImplWriter.write("    public boolean freeUpdate(String sql) {\r\n");
        serviceImplWriter.write("        return dao.freeUpdate(sql);\r\n");
        serviceImplWriter.write("    }\r\n");
        serviceImplWriter.newLine();
        serviceImplWriter.newLine();
        serviceImplWriter.write("    @Override \r\n");
        serviceImplWriter.write("    public List<"+javaBeanName+"> search("+javaBeanName+" "+javaPackageName+") {\r\n");
        serviceImplWriter.write("            String sql = \"select * from "+tableName+" where 1=1 \"; \r\n");
        int count = metaData.getColumnCount();
        for(int i=2;i<=count;i++) {
            //列名 小写
            String columnName = metaData.getColumnName(i);
            String javaCol = BaseDao.dbColsToJavaCols(columnName);
            String upperCaseColumnName = dao.toUpperCaseFirstOne(javaCol);
            serviceImplWriter.write("            if ("+javaPackageName+".get"+upperCaseColumnName+"()!=null && !\"\".equals("+javaPackageName+".get"+upperCaseColumnName+"())){        \r\n");
            serviceImplWriter.write("                sql+=\" and "+columnName+" like '%\"+"+javaPackageName+".get"+upperCaseColumnName+"()+\"%' \";        \r\n");
            serviceImplWriter.write("            } \r\n");
        }
        serviceImplWriter.write("            List<"+javaBeanName+"> list = dao.freeFind(sql);        \r\n");
        serviceImplWriter.write("            return list;        \r\n");
        serviceImplWriter.write("    }\r\n");
        serviceImplWriter.newLine();
        serviceImplWriter.newLine();
        serviceImplWriter.write("}");
        serviceImplWriter.close();
    }

    /**
     * Service模板
     * @param javaBeanName
     * @param serviceWriter
     * @param now
     * @throws IOException
     */
    private static void generateService(ResultSetMetaData metaData,String javaBeanName, BufferedWriter serviceWriter, String now) throws IOException, SQLException {
        serviceWriter.write("package com.qhit."+javaPackageName+".service;");
        serviceWriter.newLine();
        serviceWriter.newLine();
        serviceWriter.write("import java.util.List;");
        serviceWriter.newLine();
        serviceWriter.write("import com.qhit."+javaPackageName+".pojo."+javaBeanName+";\r\n");
        serviceWriter.write("/**");
        serviceWriter.newLine();
        serviceWriter.write("* Created by GeneratorCode on "+now);
        serviceWriter.newLine();
        serviceWriter.write("*/");
        serviceWriter.newLine();
        serviceWriter.newLine();
        serviceWriter.write("public interface I"+javaBeanName+"Service {");
        serviceWriter.newLine();
        serviceWriter.newLine();
        serviceWriter.write("    boolean insert(Object object);");
        serviceWriter.newLine();
        serviceWriter.newLine();
        serviceWriter.write("    boolean  update(Object object);");
        serviceWriter.newLine();
        serviceWriter.newLine();
        serviceWriter.write("    boolean  updateSelective(Object object);");
        serviceWriter.newLine();
        serviceWriter.newLine();
        serviceWriter.write("    boolean delete(Object id);");
        serviceWriter.newLine();
        serviceWriter.newLine();
        serviceWriter.write("    List findAll();");
        serviceWriter.newLine();
        serviceWriter.newLine();
        serviceWriter.write("    "+javaBeanName+" findById(Object id);");
        serviceWriter.newLine();
        serviceWriter.newLine();
        serviceWriter.write("    boolean freeUpdate(String sql);");
        serviceWriter.newLine();
        serviceWriter.newLine();
        serviceWriter.write("    List<"+javaBeanName+"> search("+javaBeanName+" "+javaPackageName+");");
        serviceWriter.newLine();
        serviceWriter.newLine();

        serviceWriter.write("}");
        serviceWriter.close();
    }


    //删除文件夹
    public static void delFolder(String folderPath) {
        try {
            delAllFile(folderPath); //删除完里面所有内容
            String filePath = folderPath;
            filePath = filePath.toString();
            File myFilePath = new File(filePath);
            myFilePath.delete(); //删除空文件夹
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //删除指定文件夹下所有文件
//param path 文件夹完整绝对路径
    public static boolean delAllFile(String path) {
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            return flag;
        }
        if (!file.isDirectory()) {
            return flag;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                delAllFile(path + "/" + tempList[i]);//先删除文件夹里面的文件
                delFolder(path + "/" + tempList[i]);//再删除空文件夹
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 创建文件夹
     */
    private static void makeSomeDirs(File dir) {
        File file1 = new File(dir.getAbsolutePath()+"\\com\\qhit\\"+javaPackageName+"\\pojo");
        File file2 = new File(dir.getAbsolutePath()+"\\com\\qhit\\"+javaPackageName+"\\dao\\impl");
        File file3 = new File(dir.getAbsolutePath()+"\\com\\qhit\\"+javaPackageName+"\\service\\impl");
        File file4 = new File(dir.getAbsolutePath()+"\\com\\qhit\\"+javaPackageName+"\\controller");
        File file5 = new File(dir.getAbsolutePath()+"\\jsp\\"+javaPackageName);
        file1.mkdirs();
        file2.mkdirs();
        file3.mkdirs();
        file4.mkdirs();
        file5.mkdirs();
    }

    /**
     * 查询字段的注释
     * @param conn
     * @param metaData
     * @return
     * @throws SQLException
     */
    private static String[] findComments(Connection conn,  ResultSetMetaData metaData) throws SQLException {
        //字段注释
        String[] comments = new String[metaData.getColumnCount()];
        String commentSql = "show full columns from "+tableName;
        PreparedStatement ps2 = conn.prepareStatement(commentSql);
        ResultSet set = ps2.executeQuery();
        int j = 0;
        while (set.next()){
            comments[j] = set.getString("Comment").trim();
            j++;
        }
        return comments;
    }

}
