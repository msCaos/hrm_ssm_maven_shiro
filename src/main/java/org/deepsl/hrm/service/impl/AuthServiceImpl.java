package org.deepsl.hrm.service.impl;

import org.deepsl.hrm.dao.UserDao;
import org.deepsl.hrm.dao.auth.SysPermissionMapperCustom;
import org.deepsl.hrm.dao.auth.SysRoleDao;
import org.deepsl.hrm.domain.User;
import org.deepsl.hrm.domain.auth.SysPermission;
import org.deepsl.hrm.domain.auth.SysRole;
import org.deepsl.hrm.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AuthServiceImpl implements AuthService {



    @Autowired
    UserDao userDao;

    @Autowired
    SysPermissionMapperCustom sysPermissionMapperCustom;

    @Override
    public User findUserByLoginName(String loginname) {
        return userDao.findUserByLoginName(loginname);
    }

    @Override
    public List<SysPermission> findPermissionsByUserId(Integer id) {


        return sysPermissionMapperCustom.findPermissionListByUserId(id);
    }
}
