package com.xiaoniu.transaction.service.impl;

import com.xiaoniu.transaction.dao.UserInfoDOMapper;
import com.xiaoniu.transaction.dao.UserPasswordDOMapper;
import com.xiaoniu.transaction.dataObject.UserInfoDO;
import com.xiaoniu.transaction.dataObject.UserPasswordDO;
import com.xiaoniu.transaction.error.BusinessException;
import com.xiaoniu.transaction.error.EmBusinessError;
import com.xiaoniu.transaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoDOMapper userInfoDOMapper;
    @Autowired
    private UserPasswordDOMapper userPasswordDOMapper;


    @Override
    public UserInfoDO register(String email, String userName, String password) throws BusinessException {
        if (StringUtils.isEmpty(email)) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "邮箱为空");
        }
        if (StringUtils.isEmpty(userName)) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "用户名为空");
        }
        if (StringUtils.isEmpty(password)) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "密码为空");
        }
        UserInfoDO userInfoDO = new UserInfoDO();
        userInfoDO.setEmail(email);
        userInfoDO.setUserName(userName);
        userInfoDOMapper.insertSelective(userInfoDO);

        UserPasswordDO userPasswordDO = new UserPasswordDO();
        userPasswordDO.setUserId(userInfoDO.getUserId());
        userPasswordDO.setPassword(password);
        userPasswordDOMapper.insertSelective(userPasswordDO);
        return userInfoDO;
    }

    @Override
    public UserInfoDO loginByEmail(String email, String password) throws BusinessException {
        if (StringUtils.isEmpty(email)) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "邮箱为空");
        }
        if (StringUtils.isEmpty(password)) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "密码为空");
        }

        UserInfoDO userInfoDO = userInfoDOMapper.selectByEmail(email);
        if (userInfoDO == null) {
            throw new BusinessException(EmBusinessError.LOGIN_FAIL);
        }
        UserPasswordDO userPasswordDO = userPasswordDOMapper.selectByPrimaryKey(userInfoDO.getUserId());


        if (userPasswordDO.getPassword().equals(password)) {
            //密码正确
            return userInfoDO;
        } else {
            //密码错误
            throw new BusinessException(EmBusinessError.LOGIN_FAIL);
        }

    }
}
