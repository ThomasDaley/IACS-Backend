package com.moncyja.iacs.request;

import lombok.Data;

@Data
public class LoginRequest {

    private String loginCode;

    private String userPassword;

    private String identifyingCode;
}
