package net.cnki.utils;

import lombok.Data;
import net.cnki.common.entity.UserInfo;

import java.util.Map;

/**
 * 使用threadLocal做session
 * @Author: tianjl
 * @Date: 2020/4/16 14:53
 * @Eamil: 2695062879@qq.com
 */
@Data
public class Session {

    /**
     * 用户信息
     */
    private UserInfo userInfo;


    /**
     * 权限列表
     */
    private Map<String,Boolean> roleMap;


    /**
     * 防重复提交token
     */
    private String doubleSubmitToken;
}
