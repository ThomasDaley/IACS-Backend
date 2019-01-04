package com.moncyja.iacs.vo;

import lombok.Data;
import org.hibernate.annotations.Entity;
import com.moncyja.iacs.entity.TUserInfo;

@Data
public class LoginVo extends BaseVo{

    private TUserInfo tUserInfo;

}
