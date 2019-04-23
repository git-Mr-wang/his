package com.qhit.utils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

/**
 * Created by Administrator on 2018/11/5.
 */
@WebServlet(name = "FileUploadUtil",urlPatterns = "/FileUploadUtil")
public class FileUploadUtil extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取输入流中内容的长度
        int length = request.getContentLength();
        int realLength;
        String path = request.getSession().getServletContext().getRealPath("upload");
//       获取输入流
        ServletInputStream inputStream = request.getInputStream();
//        将输入流中的内容写入到一个临时文本中
        FileOutputStream fos = new FileOutputStream(path+"\\temp.txt");
        int b;
        while((b=inputStream.read())!=-1){
            fos.write(b);
        }
        fos.flush();
        RandomAccessFile randomAccessFile = new RandomAccessFile(path+"\\temp.txt","r");
        String firstLine = randomAccessFile.readLine();
        String secondLine = randomAccessFile.readLine();
        secondLine = new String( secondLine.getBytes("iso-8859-1"),"utf-8");
//      从第二行中获取filename
        String[] arr = secondLine.split("; ");
        String filename = UUID.randomUUID().toString()+arr[2].substring(10,arr[2].length()-1);
        String name = arr[1].substring(6,arr[1].length()-1);
        String thirdLine = randomAccessFile.readLine();
        randomAccessFile.readLine();
        FileOutputStream fos2 = new FileOutputStream(path+"\\"+filename);
        realLength = length  - firstLine.getBytes("iso-8859-1").length
                -secondLine.getBytes("utf-8").length
                -thirdLine.getBytes("iso-8859-1").length
                -firstLine.getBytes("iso-8859-1").length-2-12;
        int c;
        int count = 0;
        byte buffer [] = new byte[10240];
        while ((c=randomAccessFile.read(buffer))!=-1){
            if(count+c>=realLength){
                c=realLength-count;
                fos2.write(buffer,0,c);
                break;
            }else{
                fos2.write(buffer,0,c);
                count+=c;
            }
        }
//        关流
        fos.close();
        fos2.close();
        randomAccessFile.close();
        inputStream.close();
        request.setAttribute("filename",filename);
        request.setAttribute("name",name);
        request.getRequestDispatcher("files/message.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
