package org.deepsl.hrm.service;

import org.deepsl.hrm.domain.User;
import org.deepsl.hrm.domain.auth.SysPermission;

import java.util.List;

public interface AuthService {

   User findUserByLoginName(String loginname);


   List<SysPermission> findPermissionsByUserId(Integer id);
}
