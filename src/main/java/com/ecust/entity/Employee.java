package com.ecust.entity;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private String name;

    private String password;

    private String phone;

    private String sex;

    private String idNumber;

    private Integer status;

   // @JsonDeserialize(using = LocalDateTimeDeserializer.class)		// 反序列化
    //@JsonSerialize(using = LocalDateTimeSerializer.class)		// 序列化
    private LocalDateTime createTime;

    //@JsonDeserialize(using = LocalDateTimeDeserializer.class)		// 反序列化
    //@JsonSerialize(using = LocalDateTimeSerializer.class)		// 序列化
    private LocalDateTime updateTime;


    private Long createUser;


    private Long updateUser;

}
