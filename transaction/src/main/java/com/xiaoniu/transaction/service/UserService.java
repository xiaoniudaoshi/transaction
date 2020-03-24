package com.xiaoniu.transaction.service;

import com.xiaoniu.transaction.dataObject.UserInfoDO;
import com.xiaoniu.transaction.error.BusinessException;

public interface UserService {
    //注册(邮箱+用户名+密码)
    UserInfoDO register(String email, String userName, String password) throws BusinessException;

    //登陆（邮箱+密码）
    UserInfoDO loginByEmail(String email, String password) throws BusinessException;

}
