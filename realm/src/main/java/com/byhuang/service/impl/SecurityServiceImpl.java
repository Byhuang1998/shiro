package com.byhuang.service.impl;

import com.byhuang.service.SecurityService;

/**
 * @author huangbingyi
 * @version 1.0
 * @date 2023/2/14 15:26
 * @description 简单模拟一下数据库
 */
public class SecurityServiceImpl implements SecurityService {

    public String getPwdByLoginName(String loginName) {
        if ("jay".equals(loginName)) {
            return "123";
        }
        return null;
    }
}
