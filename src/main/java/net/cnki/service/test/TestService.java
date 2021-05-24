package net.cnki.service.test;

import net.cnki.controller.test.TestRequest;
import net.cnki.utils.ResponseResult;

/**
 * @Author: tianjl
 * @Date: 2021/5/18 17:05
 * @Eamil: 2695062879@qq.com
 */
public interface TestService {
    /**
     * 从路径中获取值
     * @param id id
     * @return 是否成功
     */
    ResponseResult path(String id);

    /**
     * form表单
     * @param request 表单提交的内容
     * @return 是否成功
     */
    ResponseResult testFormdate(TestRequest request);

    /**
     * 测试上送json
     * @param request 请求体
     * @return 是否上送json成功
     */
    ResponseResult testJson(TestRequest request);
}
