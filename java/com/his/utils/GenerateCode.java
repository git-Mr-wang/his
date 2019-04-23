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
 * 根据表名，自动生成javabean,dao,mapper,service,service实现类
 *
 * Version 1.5
 *
   1.自动生成mapper文件
   2.自动生成下拉框,实现下拉框的自动化
 *
 */
public class GenerateCode {

    private static String tableName = "in_patient";
    private static String tableChineseName = "病人";
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
        //Mapper文件
        String mapperName = javaBeanName+"Mapper.xml";
        BufferedWriter mapperWriter= new BufferedWriter(new FileWriter(dir.getAbsolutePath()+"\\com\\qhit\\"+javaPackageName+"\\dao\\"+mapperName));
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
        //mapper文件
        generateMapper(metaData,javaBeanName, mapperWriter, now);
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
        controllerWriter.write("/** \r\n");
        controllerWriter.write("* Created by GeneratorCode on "+now+"\r\n");
        controllerWriter.write("*/ \r\n");
        controllerWriter.newLine();
        controllerWriter.write("@Controller \r\n");
        controllerWriter.write("@RequestMapping(\"/"+javaPackageName+"\") \r\n");
        controllerWriter.write("public class "+javaBeanName+"Controller { \r\n");
        controllerWriter.newLine();
        controllerWriter.write("    @Resource \r\n");
        controllerWriter.write("    I"+javaBeanName+"Service "+javaPackageName+"Service; \r\n");
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

    private static void generateMapper(ResultSetMetaData metaData,String javaBeanName, BufferedWriter mapperWriter, String now) throws IOException, SQLException {
        mapperWriter.write("<?xml version=\"1.0\" encoding=\"utf-8\"?> \r\n");
        mapperWriter.write("<!DOCTYPE mapper PUBLIC \"-//mybatis.org/DTD Mapper 3.0\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\"> \r\n");
        mapperWriter.write("<mapper namespace=\"com.qhit."+javaPackageName+".dao.I"+javaBeanName+"Dao\"> \r\n");
        mapperWriter.write("\t<!-- 自定义结果集 --> \r\n");
        mapperWriter.write("\t<resultMap id=\"BaseResultMap\" type=\"com.qhit."+javaPackageName+".pojo."+javaBeanName+"\"> \r\n");
        int count = metaData.getColumnCount();
        //主键
        String primarykey = metaData.getColumnName(1);
        String priName = BaseDao.dbColsToJavaCols(primarykey);
        mapperWriter.write("\t\t<id property=\""+priName+"\" column=\""+primarykey+"\" javaType=\"java.lang.Integer\"></id> \r\n");
        for(int i=2;i<=count;i++) {
            //列名 小写
            String columnName = metaData.getColumnName(i);
            String javaCol = BaseDao.dbColsToJavaCols(columnName);
            String upperCaseColumnName = dao.toUpperCaseFirstOne(javaCol);
            //列类型 大写
            String type = metaData.getColumnTypeName(i);
            if(type.equals("VARCHAR")||type.equals("VARCHAR2")||type.equals("TIME")||type.equals("DATE")||type.equals("DATETIME")||type.equals("TIMESTAMP")){
                mapperWriter.write("\t\t<result property=\""+javaCol+"\" column=\""+columnName+"\" javaType=\"java.lang.String\"></result> \r\n");
            }else if(type.equals("INT")){
                mapperWriter.write("\t\t<result property=\""+javaCol+"\" column=\""+columnName+"\" javaType=\"java.lang.Integer\"></result> \r\n");
            }else if(type.equals("FLOAT")){
                mapperWriter.write("\t\t<result property=\""+javaCol+"\" column=\""+columnName+"\" javaType=\"java.lang.Float\"></result> \r\n");
            }else if(type.equals("DOUBLE")){
                mapperWriter.write("\t\t<result property=\""+javaCol+"\" column=\""+columnName+"\" javaType=\"java.lang.Double\"></result> \r\n");
            }
        }
        mapperWriter.write("\t</resultMap> \r\n");
        mapperWriter.write(" \r\n");
        mapperWriter.write("\t<!-- 在各种标签中，id属性必须与接口中的方法名一样，id的值必须是唯一的，parameterType指查询时使用的参数类型， \r\n");
        mapperWriter.write("\tresultType属性指明查询返回的结果集类型    --> \r\n");
        mapperWriter.write(" \r\n");
        mapperWriter.write("\t<sql id=\"Base_Column_List\" > \r\n");
        StringBuffer baseColumnBuffer = new StringBuffer();
        for (int i = 1; i <=count ; i++) {
            String columnName = metaData.getColumnName(i);
            baseColumnBuffer.append(columnName+",");
        }
        String baseColumn = baseColumnBuffer.substring(0,baseColumnBuffer.length()-1);
        mapperWriter.write("\t\t"+baseColumn+" \r\n");
        mapperWriter.write("\t</sql> \r\n");
        mapperWriter.write("\t<select id=\"findById\" resultMap=\"BaseResultMap\" parameterType=\"java.lang.Integer\" > \r\n");
        mapperWriter.write("\t\tselect \r\n");
        mapperWriter.write("\t\t<include refid=\"Base_Column_List\" /> \r\n");
        mapperWriter.write("\t\tfrom "+tableName+" \r\n");
        mapperWriter.write("\t\twhere "+primarykey+" = #{"+priName+"} \r\n");
        mapperWriter.write("\t</select> \r\n");
        mapperWriter.write("\t<delete id=\"delete\" parameterType=\"java.lang.Integer\" > \r\n");
        mapperWriter.write("\t\tdelete from "+tableName+" \r\n");
        mapperWriter.write("\t\twhere "+primarykey+" = #{"+priName+"} \r\n");
        mapperWriter.write("\t</delete> \r\n");
        mapperWriter.write("\t<insert id=\"insert\" parameterType=\"com.qhit."+javaPackageName+".pojo."+javaBeanName+"\" > \r\n");
        StringBuffer insertIntoBuffer = new StringBuffer("insert into "+tableName+"(");
        StringBuffer insertValueBuffer = new StringBuffer("values (");
        for(int i=2;i<=count;i++) {
            //列名 小写
            String columnName = metaData.getColumnName(i);
            String javaCol = BaseDao.dbColsToJavaCols(columnName);
            insertIntoBuffer.append(columnName+",");
            insertValueBuffer.append("#{"+javaCol+"},");
        }
        String insertInto = insertIntoBuffer.substring(0,insertIntoBuffer.length()-1);
        insertInto += ")";
        String insertValue = insertValueBuffer.substring(0,insertValueBuffer.length()-1);
        insertValue += ")";
        mapperWriter.write("\t\t"+insertInto+" \r\n");
        mapperWriter.write("\t\t"+insertValue+" \r\n");
        mapperWriter.write("\t</insert> \r\n");
        mapperWriter.write("\t<update id=\"updateSelective\" parameterType=\"com.qhit."+javaPackageName+".pojo."+javaBeanName+"\" > \r\n");
        mapperWriter.write("\t\tupdate "+tableName+" \r\n");
        mapperWriter.write("\t\t<set > \r\n");
        for(int i=2;i<=count;i++) {
            //列名 小写
            String columnName = metaData.getColumnName(i);
            String javaCol = BaseDao.dbColsToJavaCols(columnName);
            mapperWriter.write("\t\t\t<if test=\""+javaCol+" != null and "+javaCol+"!='' \" > \r\n");
            mapperWriter.write("\t\t\t\t"+columnName+" = #{"+javaCol+"}, \r\n");
            mapperWriter.write("\t\t\t</if> \r\n");
        }
        mapperWriter.write("\t\t</set> \r\n");
        mapperWriter.write("\t\twhere "+primarykey+" = #{"+priName+"} \r\n");
        mapperWriter.write("\t</update> \r\n");
        mapperWriter.write("\t<update id=\"update\" parameterType=\"com.qhit."+javaPackageName+".pojo."+javaBeanName+"\" > \r\n");
        mapperWriter.write("\t\tupdate "+tableName+" \r\n");
        StringBuffer updateBuffer = new StringBuffer("set ");
        for(int i=2;i<=count;i++) {
            //列名 小写
            String columnName = metaData.getColumnName(i);
            String javaCol = BaseDao.dbColsToJavaCols(columnName);
            updateBuffer.append(" "+columnName+" = #{"+javaCol+"},");
        }
        String updateStr = updateBuffer.substring(0,updateBuffer.length()-1);
        mapperWriter.write("\t\t"+updateStr+" \r\n");
        mapperWriter.write("\t\twhere "+primarykey+" = #{"+priName+"} \r\n");
        mapperWriter.write("\t</update> \r\n");

        mapperWriter.write("\t<select id=\"findAll\" resultMap=\"BaseResultMap\" > \r\n");
        mapperWriter.write("\t\tselect \r\n");
        mapperWriter.write("\t\t<include refid=\"Base_Column_List\" /> \r\n");
        mapperWriter.write("\t\tfrom "+tableName+" \r\n");
        mapperWriter.write("\t</select> \r\n");

        for(int i=2;i<=count;i++) {
            //列名 小写
            String columnName = metaData.getColumnName(i);
            String javaCol = BaseDao.dbColsToJavaCols(columnName);
            String upperCaseColumnName = dao.toUpperCaseFirstOne(javaCol);
            //列类型 大写
            String type = metaData.getColumnTypeName(i);
            if(type.equals("VARCHAR")||type.equals("VARCHAR2")||type.equals("TIME")||type.equals("DATE")||type.equals("DATETIME")||type.equals("TIMESTAMP")){
                mapperWriter.write("\t<select id=\"findBy"+upperCaseColumnName+"\" resultMap=\"BaseResultMap\" parameterType=\"java.lang.String\" > \r\n");
            }else if(type.equals("INT")){
                mapperWriter.write("\t<select id=\"findBy"+upperCaseColumnName+"\" resultMap=\"BaseResultMap\" parameterType=\"java.lang.Integer\" > \r\n");
            }else if(type.equals("FLOAT")){
                mapperWriter.write("\t<select id=\"findBy"+upperCaseColumnName+"\" resultMap=\"BaseResultMap\" parameterType=\"java.lang.Float\" > \r\n");
            }else if(type.equals("DOUBLE")){
                mapperWriter.write("\t<select id=\"findBy"+upperCaseColumnName+"\" resultMap=\"BaseResultMap\" parameterType=\"java.lang.Double\" > \r\n");
            }
            mapperWriter.write("\t\tselect \r\n");
            mapperWriter.write("\t\t<include refid=\"Base_Column_List\" /> \r\n");
            mapperWriter.write("\t\tfrom "+tableName+" \r\n");
            mapperWriter.write("\t\twhere "+columnName+" = #{"+javaCol+"} \r\n");
            mapperWriter.write("\t</select> \r\n");

        }

//        批量删除
        mapperWriter.write("\t<delete id=\"deleteBatch\" parameterType=\"java.util.Arrays\"> \r\n");
        mapperWriter.write("\t\tdelete from "+tableName+" where "+primarykey+" in \r\n");
        mapperWriter.write("\t\t<foreach collection=\"array\" item=\"id\" open=\"(\" close=\")\" separator=\",\"> \r\n");
        mapperWriter.write("\t\t\t#{id} \r\n");
        mapperWriter.write("\t\t</foreach> \r\n");
        mapperWriter.write("\t</delete> \r\n");
//      查询
        mapperWriter.write("\t<select id=\"search\" parameterType=\"com.qhit."+javaPackageName+".pojo."+javaBeanName+"\" resultMap=\"BaseResultMap\"> \r\n");
        mapperWriter.write("\t\tselect * from  "+tableName+" \r\n");
        mapperWriter.write("\t\t<where > \r\n");
        for(int i=2;i<=count;i++) {
            //列名 小写
            String columnName = metaData.getColumnName(i);
            String javaCol = BaseDao.dbColsToJavaCols(columnName);
            mapperWriter.write("\t\t\t<if test=\""+javaCol+" != null and "+javaCol+"!='' \" > \r\n");
            mapperWriter.write("\t\t\t\t and "+columnName+" = #{"+javaCol+"} \r\n");
            mapperWriter.write("\t\t\t</if> \r\n");
        }
        mapperWriter.write("\t\t</where> \r\n");
        mapperWriter.write("\t</select> \r\n");

        mapperWriter.write("</mapper> \r\n");
        mapperWriter.close();
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
        daoWriter.write("import org.springframework.stereotype.Repository;\r\n");
        daoWriter.write("import com.qhit."+javaPackageName+".pojo."+javaBeanName+";\r\n");
        daoWriter.write("import java.util.List;\r\n");
        daoWriter.newLine();
        daoWriter.write("/**");
        daoWriter.newLine();
        daoWriter.write("* Created by GeneratorCode on "+now);
        daoWriter.newLine();
        daoWriter.write("*/");
        daoWriter.newLine();
        daoWriter.newLine();
        daoWriter.write("@Repository  \r\n");
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
        daoWriter.write("    List<"+javaBeanName+"> search("+javaBeanName+" "+javaPackageName+");");
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
        serviceImplWriter.write("import com.qhit."+javaPackageName+".pojo."+javaBeanName+";\r\n");
        serviceImplWriter.write("import org.springframework.stereotype.Service;\r\n");
        serviceImplWriter.write("import javax.annotation.Resource; \r\n");
        serviceImplWriter.newLine();
        serviceImplWriter.write("/**");
        serviceImplWriter.newLine();
        serviceImplWriter.write("* Created by GeneratorCode on "+now);
        serviceImplWriter.newLine();
        serviceImplWriter.write("*/");
        serviceImplWriter.newLine();
        serviceImplWriter.newLine();
        serviceImplWriter.write("@Service \r\n");
        serviceImplWriter.write("public class "+javaBeanName+"ServiceImpl  implements I"+javaBeanName+"Service {");
        serviceImplWriter.newLine();
        serviceImplWriter.newLine();
        serviceImplWriter.write("    @Resource \r\n");
        serviceImplWriter.write("    I"+javaBeanName+"Dao dao;");
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
        serviceImplWriter.write("    public List<"+javaBeanName+"> search("+javaBeanName+" "+javaPackageName+") { \r\n");
        serviceImplWriter.write("        return dao.search("+javaPackageName+"); \r\n");
        serviceImplWriter.write("    } \r\n");
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
        File file2 = new File(dir.getAbsolutePath()+"\\com\\qhit\\"+javaPackageName+"\\dao");
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
