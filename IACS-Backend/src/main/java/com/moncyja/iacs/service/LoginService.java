package com.moncyja.iacs.service;

import com.moncyja.iacs.entity.TUserInfo;
import com.moncyja.iacs.request.LoginRequest;
import com.moncyja.iacs.request.RegisterRequest;

public interface LoginService {

    TUserInfo getUserInfo(LoginRequest loginRequest);

    int setUserInfo(RegisterRequest registerRequest);
}
