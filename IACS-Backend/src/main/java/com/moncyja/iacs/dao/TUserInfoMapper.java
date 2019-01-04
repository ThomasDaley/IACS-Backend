package com.moncyja.iacs.dao;

import com.moncyja.iacs.entity.TUserInfo;
import com.moncyja.iacs.request.LoginRequest;
import com.moncyja.iacs.request.RegisterRequest;

public interface TUserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TUserInfo record);

    int insertSelective(TUserInfo record);

    TUserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TUserInfo record);

    int updateByPrimaryKey(TUserInfo record);

    TUserInfo selectByLoginRequest(LoginRequest loginRequest);

    int selectByUserAccount(String userAccount);

    int setUserInfo(RegisterRequest registerRequest);
}