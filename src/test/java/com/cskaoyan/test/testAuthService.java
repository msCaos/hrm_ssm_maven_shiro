package com.cskaoyan.test;

import org.deepsl.hrm.domain.User;
import org.deepsl.hrm.domain.auth.SysPermission;
import org.deepsl.hrm.service.AuthService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext*.xml")
public class testAuthService {


    @Autowired
    AuthService authService;


    @Test
    public void test1(){


        User admin = authService.findUserByLoginName("admin");

        System.out.println("admin="+admin);
    }

    @Test
    public void test2(){


        List<SysPermission> permissionsByUserId = authService.findPermissionsByUserId(6);

        System.out.println("permissionsByUserId="+permissionsByUserId);
    }

}
