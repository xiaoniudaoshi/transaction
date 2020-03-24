package com.xiaoniu.transaction.controller;


import com.xiaoniu.transaction.dataObject.UserInfoDO;
import com.xiaoniu.transaction.error.BusinessException;
import com.xiaoniu.transaction.response.CommonReturnType;
import com.xiaoniu.transaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //注册（邮箱+用户名+密码）
    @PostMapping("/register")
    public CommonReturnType register(@RequestParam("email") String email,
                                     @RequestParam("userName") String userName,
                                     @RequestParam("password") String password) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        UserInfoDO userInfoDO = userService.register(email, userName, EncodeByMD5(password));
        return CommonReturnType.create(userInfoDO);
    }


    //登录(邮箱+密码)
    @PostMapping("/loginByEmail")
    public CommonReturnType loginByEmail(@RequestParam("email") String email,
                                         @RequestParam("password") String password) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        UserInfoDO userInfoDO = userService.loginByEmail(email, EncodeByMD5(password));
        return CommonReturnType.create(userInfoDO);
    }


    //密码加密
    private String EncodeByMD5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //确定计算方式
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder = new BASE64Encoder();
        //加密字符串
        String newstr = base64Encoder.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }
}
