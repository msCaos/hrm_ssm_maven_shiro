package org.deepsl.hrm.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.deepsl.hrm.domain.User;
import org.deepsl.hrm.domain.auth.SysPermission;
import org.deepsl.hrm.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class CustomRealm extends AuthorizingRealm {


    @Autowired
    AuthService authService;

    @Override
    public String getName() {
        return "CustomRealm";
    }

    //认证的时候，需要我们去调用自己的realm，返回用户认证的信息，从数据库里返回
    //这里只是返回当前用户的认证信息
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {


        String principal = (String) authenticationToken.getPrincipal();
        System.out.println("principal="+principal);


        //去数据库里查询用户名叫张三的用户信息
        User user = authService.findUserByLoginName(principal);


        //密码是123456
        //去数据库里查询用户名叫张三的用户信息,包含密码的md5，以及盐值
        String password_getfrom_db = "88316675d7882e3fdbe066000273842c";
        String  solt = "aaa";

        //参数一也就是身份信息，会被放入到Session域里。
        SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(
                user,
                password_getfrom_db,
                Md5Hash.Util.bytes(solt),
                getName()
        );


        return simpleAuthenticationInfo;
    }




    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        //根据用户信息去查询该用户的授权信息，
        User primaryPrincipal = (User) principalCollection.getPrimaryPrincipal();

        List<SysPermission> permissions= authService.findPermissionsByUserId(primaryPrincipal.getId());

        System.out.println("primaryPrincipal="+primaryPrincipal);

        //授权信息
        SimpleAuthorizationInfo authorizationInfo =new SimpleAuthorizationInfo();


        for (SysPermission permission:permissions) {

            authorizationInfo.addStringPermission(permission.getPercode());

        }


        return authorizationInfo;
    }


    public void clearCache(){

        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);

    }

}
