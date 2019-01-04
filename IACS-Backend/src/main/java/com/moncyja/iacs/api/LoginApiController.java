package com.moncyja.iacs.api;

import com.moncyja.iacs.entity.TUserInfo;
import com.moncyja.iacs.request.LoginRequest;
import com.moncyja.iacs.request.RegisterRequest;
import com.moncyja.iacs.service.LoginService;
import com.moncyja.iacs.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginApiController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String getUserInfo(LoginRequest loginRequest) {
        LoginVo loginVo = new LoginVo();
        TUserInfo result = loginService.getUserInfo(loginRequest);
        if (result != null) {
            loginVo.setCode("200");
            loginVo.setMessage("登陆成功");
            loginVo.setTUserInfo(result);
        } else {
            loginVo.setCode("500");
            loginVo.setMessage("用户名或密码错误");
        }
        return loginVo.getMessage();
    }

    @GetMapping("/register")
    public String setUserInfo(RegisterRequest registerRequest) {
        LoginVo loginVo = new LoginVo();
        int result = loginService.setUserInfo(registerRequest);
        if (result == 1) {
            loginVo.setCode("200");
            loginVo.setMessage("注册成功");
        } else if (result == 500) {
            loginVo.setMessage("注册失败，请与管理员联系");
        } else if (result == 0){
            loginVo.setMessage("用户名已存在");
        }
        return loginVo.getMessage();
    }
}
