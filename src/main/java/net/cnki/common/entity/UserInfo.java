package net.cnki.common.entity;

import lombok.Data;

/**
 * @Author: tianjl
 * @Date: 2020/9/23 18:09
 * @Eamil: 2695062879@qq.com
 */
@Data
public class UserInfo {

    /**
     * userid
     */
    private String userId;

    /**
     * useranem
     */
    private String userName;

    /**
     * email
     */
    private String email;

    /**
     * pthon
     */
    private String phone;
}
