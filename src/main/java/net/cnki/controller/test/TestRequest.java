package net.cnki.controller.test;

import lombok.Data;

import javax.validation.constraints.NotEmpty;


/**
 * @Author: tianjl
 * @Date: 2021/5/18 16:17
 * @Eamil: 2695062879@qq.com
 */
@Data
public class TestRequest {
    /**
     * id
     */
    @NotEmpty(message = "id不能为空！")
    private String id;
}
