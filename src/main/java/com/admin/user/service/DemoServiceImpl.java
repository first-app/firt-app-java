package com.admin.user.service;

import com.admin.user.dao.AdminUser;
import com.admin.user.mapper.AdminUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("DemoService")
public class DemoServiceImpl implements DemoService {

    @Autowired
    private AdminUserMapper adminUserMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Object addUserRequired(String userId) {
        AdminUser adminUser =new AdminUser();
        adminUser.setUserId(userId);
        adminUser.setPassword("12456");
        adminUser.setPhone("1234568");
        adminUser.setEmail("1212");
        adminUser.setSex(1);
        adminUserMapper.addUser(adminUser);
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Object delUserRequiredNew(String userId) {
        adminUserMapper.delUser(userId);
        throw new RuntimeException();
    }
}
