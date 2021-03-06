package com.equipment.management.entity.security;

import lombok.Data;

import java.util.Date;

/**
 * @program: securtitydemo
 * @description: 为了获取token中的用户信息，将token中的载荷部分单独封装成一个对象
 * @created: 2020/09/18 10:43
 */
@Data
public class Payload<T> {
    private String id;
    private T userInfo;
    private Date expiration;
}
