package com.byhuang;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * @author huangbingyi
 * @version 1.0
 * @date 2023/2/14 15:28
 * @description TODO
 */
public class ShiroLogin {

    public static void main(String[] args) {
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("jay", "123");
        subject.login(token);
        System.out.println("subject.isAuthenticated() = " + subject.isAuthenticated());
    }
}
