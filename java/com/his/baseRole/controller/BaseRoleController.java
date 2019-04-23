package com.qhit.baseRole.controller;


import com.qhit.baseFunction.pojo.BaseFunction;
import com.qhit.baseRole.pojo.BaseRole;
import com.qhit.baseRole.service.IBaseRoleService;
import com.qhit.baseRole.service.impl.BaseRoleServiceImpl;
import com.qhit.baseRoleFunction.pojo.BaseRoleFunction;
import com.qhit.baseRoleFunction.service.IBaseRoleFunctionService;
import com.qhit.baseRoleFunction.service.impl.BaseRoleFunctionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/baseRole")
public class BaseRoleController {
    private IBaseRoleService is=new BaseRoleServiceImpl();
    private IBaseRoleFunctionService ifs=new BaseRoleFunctionServiceImpl();

    @RequestMapping("/list")
    public String list(Model model){
        List all = is.findAll();
        model.addAttribute("list",all);
        return "baseRole/list";
    }

    //增加BaseFunction
    @RequestMapping("/insert")

    public String insert(BaseRole baseRole){
        boolean insert = is.insert(baseRole);
        BaseRole byRname = is.findByRname(baseRole.getRname());
        BaseRoleFunction bf = new BaseRoleFunction();
        bf.setRid(byRname.getRid());
        bf.setFid(9);
        boolean insert1 = ifs.insert(bf);
        return "forward:list.action";
    }

    //根据指定数据查找数据，并返回数据到指定页面
    @RequestMapping("/load")
    public String load(BaseRole baseRole,Model model,HttpServletRequest request){
        boolean quanxian = (boolean) request.getAttribute("quanxian");
        if (!quanxian){
            return "error/authority";
        }
        BaseRole byId = is.findById(baseRole.getRid());
        model.addAttribute("baseRole",byId);
        return "baseRole/edit";
    }

    //执行更新操作
    @RequestMapping("/update")
    public String update(BaseRole baseRole){
        is.updateSelective(baseRole);
        return "forward:list.action";
    }

    //执行删除操作
    @RequestMapping("/delete")
    public String delete(BaseRole baseRole,HttpServletRequest request){
        boolean quanxian = (boolean) request.getAttribute("quanxian");
        if (!quanxian){
            return "error/authority";
        }
        boolean delete = is.delete(baseRole.getRid());
        List<BaseRoleFunction>list = ifs.findByRid(baseRole.getRid());
        ifs.delete(list.get(0).getRmid());
        return "forward:list.action";
    }

    //查询
    @RequestMapping("/query")
    public String query(BaseRole baseRole,Model model){
        List<BaseRole> list = is.findByName(baseRole.getRname());
        model.addAttribute("list",list);
        model.addAttribute("rname",baseRole.getRname());
//        model.addAttribute("fname",baseFunction.getFname());
        return "baseRole/list";
    }

    @RequestMapping("/details")
    public String details(BaseRole baseRole){
//        System.out.println(baseRole.);
        return "baseRole/list";
    }
    @RequestMapping("/distributeLoad")
    public String distributeLoad(BaseRole baseRole, Model model){
        List<BaseFunction> leftList = is.distributeLeft(baseRole);
        List<BaseFunction> rightList = is.distributeRight(baseRole);
        model.addAttribute("leftList",leftList);
        model.addAttribute("rightList",rightList);
        model.addAttribute("rid",baseRole.getRid());
        return "baseRole/distribute";
    }
    @RequestMapping("/distributeUpdate")
    public String distributeUpdate(BaseRole baseRole, HttpServletRequest request){
        String[] fid = request.getParameterValues("fid");
//        for (String s:fid){
//            System.out.println(s);
//        }
//        System.out.println(baseRole.getRid());
        is.distributeUpdate(baseRole.getRid(),fid);
        return "forward:list.action";
    }


}
