package com.moncyja.iacs.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegisterRequest {

    private String userAccount;

    private String userPassword;

    private String userNickname;

    private Integer freezeFlag;

    private Integer delFlag;

    private LocalDateTime createTime;

    private String createdBy;

    private LocalDateTime updateTime;

    private String updatedBy;
}
