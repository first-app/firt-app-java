package com.admin.user.service;

import com.admin.user.ResultBean.ResultCode;
import com.admin.user.ResultBean.ResultData;
import com.admin.user.dao.AdminUser;
import com.admin.user.mapper.AdminUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminUserServiceImpl implements AdminUserService{
    @Autowired
    private AdminUserMapper adminUserMapper;
    @Autowired AdminUserService adminUserService;

    @Override
    public ResultData addUser(AdminUser user) {
        int i = 1 /0 ;
        return adminUserMapper.addUser(user)>0?
                new ResultData(ResultCode.SUCCESS):
                new ResultData(ResultCode.ERROR);
    }


    @Override
//    @Transactional("PROPAGATION_REQUIRED")
    public ResultData getAdminUser(String userId, String password) {
        AdminUser adminUser = adminUserMapper.getAdminUser(userId, password);
        adminUserService.addTest(adminUser);
        return  adminUser!=null?
                new ResultData<>(ResultCode.SUCCESS,adminUser):
                new ResultData(ResultCode.PASSWORDERROR);
    }



    @Transactional("PROPAGATION_REQUIRED_NEW ")
    @Override
    public void addTest(AdminUser user){
        adminUserMapper.addUser(user);
        throw new RuntimeException();
    }
}
