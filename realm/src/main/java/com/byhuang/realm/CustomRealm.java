package com.byhuang.realm;

import com.byhuang.service.SecurityService;
import com.byhuang.service.impl.SecurityServiceImpl;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.StringUtils;

/**
 * @author huangbingyi
 * @version 1.0
 * @date 2023/2/14 15:31
 * @description TODO
 */
public class CustomRealm extends AuthorizingRealm {

    // 重写认证方法
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        SecurityService service = new SecurityServiceImpl();
        String pwd = service.getPwdByLoginName((String) authenticationToken.getPrincipal());

        if (!StringUtils.hasLength(pwd)) {
            System.out.println("用户名不存在");
            return null;
        } else if (pwd.equals(String.valueOf((char[]) authenticationToken.getCredentials()))) {
            System.out.println("登录成功");
            return new SimpleAuthenticationInfo(authenticationToken.getPrincipal(), pwd, getName());
        } else {
            System.out.println("登录失败");
            return null;
        }
    }

    // 重写授权方法
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}
