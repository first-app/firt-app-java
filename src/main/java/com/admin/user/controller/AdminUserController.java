package com.admin.user.controller;

import com.admin.user.ResultBean.ResultData;
import com.admin.user.dao.AdminUser;
import com.admin.user.service.AdminUserService;
import com.admin.user.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;
    @Autowired
    private DemoService demoService;

    @RequestMapping("/test")
    public Object getTest(){
        return "测试接口1";
    }

    @RequestMapping("/addUser")
    public Object addUser(String password,String userName, String phone,String email){
        AdminUser user = new AdminUser();
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);
        user.setUserName(userName);
        user.setLevel(0);
        return adminUserService.addUser(user);
    }

    @RequestMapping("/loginAdmin")
    public Object loginAdmin(String userId,String password){
        return adminUserService.getAdminUser(userId,password);
    }

    @Transactional
    public Object demo(){
        demoService.addUserRequired("1");
        try {
            demoService.delUserRequiredNew("1");
        }catch (Exception e){

        }

        return null;
    }
    
}

