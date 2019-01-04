package com.moncyja.iacs.service.impl;

import com.moncyja.iacs.dao.TUserInfoMapper;
import com.moncyja.iacs.entity.TUserInfo;
import com.moncyja.iacs.request.LoginRequest;
import com.moncyja.iacs.request.RegisterRequest;
import com.moncyja.iacs.service.LoginService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Resource
    private TUserInfoMapper tUserInfoMapper;

    @Override
    public TUserInfo getUserInfo(LoginRequest loginRequest) {
        return tUserInfoMapper.selectByLoginRequest(loginRequest);
    }

    @Override
    public int setUserInfo(RegisterRequest registerRequest) {
        //注册账号存在标识（0：不存在，1：存在，>1：数据库需要维护)
        int existFlag;
        //账号插入标识(0：插入未成功，1：插入成功, 500：插入失败)
        int insertFlag = 500;

        existFlag = tUserInfoMapper.selectByUserAccount(registerRequest.getUserAccount());

        if (existFlag == 0) {
            try {
                insertFlag = tUserInfoMapper.setUserInfo(registerRequest);
            } catch (Exception e) {
                insertFlag = 500;
            }
        } else if (existFlag == 1) {
            existFlag = 0;
        } else {
            existFlag = 500;
        }
        return insertFlag;
    }
}
