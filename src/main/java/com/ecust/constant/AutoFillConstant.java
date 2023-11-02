package com.ecust.constant;

import org.springframework.util.DigestUtils;

/**
 * @author solang
 * @date 2023-11-02 14:31
 */
public class AutoFillConstant {
    //默认密码
    public  static final String Default_Password= DigestUtils.md5DigestAsHex("123456".getBytes()).toString();

    public  static final String Set_Create_Time="setCreateTime";
    public  static final String Set_Update_Time="setUpdateTime";
    public  static final String Set_Create_User="setCreateUser";
    public  static final String Set_Update_User="setUpdateUser";
    public  static final String Set_Status="setStatus";
    public  static final String Set_Password="setPassword";

}
