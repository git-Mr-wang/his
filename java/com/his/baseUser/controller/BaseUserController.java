package com.qhit.baseUser.controller; 

import com.qhit.baseUser.pojo.BaseUser; 
import com.qhit.baseUser.service.IBaseUserService;
import com.qhit.utils.MD5;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.RequestMapping; 
import javax.annotation.Resource; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException; 
import java.util.List; 

/** 
* Created by GeneratorCode on 2018/12/27
*/ 

@Controller 
@RequestMapping("/baseUser") 
public class BaseUserController { 

    @Resource 
    IBaseUserService baseUserService;
    private MD5 md5 = new MD5();

//    @RequestMapping("/insert")
//    public String insert(BaseUser baseUser) {
//        baseUserService.insert(baseUser);
//        return "forward:list.action";
//    }
    //增加baseUser
    @RequestMapping("/insert")
    public String insert(BaseUser baseUser){
        baseUser.setPassword(md5.getMD5ofStr(baseUser.getPassword()));
        boolean insert = baseUserService.insert(baseUser);
        return "forward:list.action";
    }

    //执行姓名和性别查询操作
    @RequestMapping("/query")
    public String query(BaseUser baseUser,HttpServletRequest request){
        List<BaseUser> list = baseUserService.query(baseUser.getCname(),baseUser.getSex());
        request.setAttribute("baseUserList",list);
        request.setAttribute("cname",baseUser.getCname());
        request.setAttribute("sex",baseUser.getSex());
        return "/baseUser/list";
    }

    //执行根据用户名和密码进行登录操作
    @RequestMapping("/login")
    public String login(BaseUser baseUser,HttpServletRequest request){
        baseUser.setPassword(md5.getMD5ofStr(baseUser.getPassword()));
        BaseUser login = baseUserService.login(baseUser);
        if (login!=null){
            HttpSession session = request.getSession();
            session.setAttribute("baseUserLogin",login);
            return "index/home";
        }else {
            request.setAttribute("error","您输入的内容有误");
            return "index/login";
        }
    }

    //退出操作
    @RequestMapping("/removeSession")
    public String remove(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("baseUserLogin");
        return "redirect:/jsp/index/login.jsp";
    }

    //更改密码
    @RequestMapping("/updatePassword")
    public void updatePassword(BaseUser baseUser,HttpServletRequest request,HttpServletResponse response){
        baseUser.setPassword(md5.getMD5ofStr(baseUser.getPassword()));
        BaseUser baseUserLogin = (BaseUser) request.getSession().getAttribute("baseUserLogin");
        baseUserLogin.setPassword(baseUser.getPassword());
        boolean b = baseUserService.updateSelective(baseUser);
        try {
            response.getWriter().write(b?"Y":"N");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //查询旧密码操作
    @RequestMapping("/findByPassword")
    public void findByPassword(BaseUser baseUser, HttpServletResponse response){
        String oldPassword = md5.getMD5ofStr(baseUser.getPassword());
        BaseUser byId = baseUserService.findById(baseUser.getUserId());
        try {
            response.getWriter().write(byId.getPassword().equals(oldPassword)?"Y":"N");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //执行删除操作
    @RequestMapping("/delete")
    public String delete(BaseUser baseUser,HttpServletRequest request){
        boolean quanxian = (boolean) request.getAttribute("quanxian");
        if (!quanxian){
            return "error/authority";
        }
        boolean delete = baseUserService.delete(baseUser.getUserId());
        return "forward:list.action";
    }

    //执行更新操作
    @RequestMapping("/update")
    public String update(BaseUser baseUser){
        baseUser.setPassword(md5.getMD5ofStr(baseUser.getPassword()));
        boolean update = baseUserService.update(baseUser);
        return "forward:list.action";
    }
 
    @RequestMapping("/updateSelective") 
    public String updateSelective(BaseUser baseUser) {
        baseUser.setPassword(md5.getMD5ofStr(baseUser.getPassword()));
        baseUserService.updateSelective(baseUser); 
        return "forward:list.action"; 
    } 

    //根据指定数据查找数据，并返回数据到指定页面
    @RequestMapping("/load")
    public String load(BaseUser baseUser,Model model,HttpServletRequest request){
        boolean quanxian = (boolean) request.getAttribute("quanxian");
        if (!quanxian){
            return "error/authority";
        }
        BaseUser byId = baseUserService.findById(baseUser.getUserId());
        model.addAttribute("baseUser",byId);
        return "baseUser/edit";
    }
 
    @RequestMapping("/list") 
    public String list(Model model) throws IOException { 
        List<BaseUser> list = baseUserService.findAll();
        for (BaseUser b:list){
            System.out.println(b.toString());
        }
        model.addAttribute("list",list); 
        return "baseUser/list"; 
    } 
 
    @RequestMapping("/ajaxList") 
    public void ajaxList(HttpServletResponse response) throws IOException { 
        List<BaseUser> list = baseUserService.findAll(); 
        String s = JSON.toJSONString(list); 
        response.getWriter().write(s); 
    }
    @RequestMapping("/ajaxSearch")
    public void ajaxSearch(Integer deptId,HttpServletResponse response) throws IOException {
        System.out.println(deptId);
        List<BaseUser> list = baseUserService.ajaxSearch(deptId);
        String s = JSON.toJSONString(list);
        response.getWriter().write(s);
    }
 
    @RequestMapping("/search") 
    public String search(BaseUser baseUser,Model model) { 
        List<BaseUser> list = baseUserService.search(baseUser); 
        model.addAttribute("list",list); 
        model.addAttribute("searchObject",baseUser); 
        return "baseUser/list"; 
    } 
 
} 
