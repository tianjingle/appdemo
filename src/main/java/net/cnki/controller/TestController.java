package net.cnki.controller;

import net.cnki.controller.test.TestRequest;
import net.cnki.service.test.TestService;
import net.cnki.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

/**
 * 这块写的控制器，按着业务分文件夹写
 */

/**
 * @Author: tianjl
 * @Date: 2021/5/18 16:17
 * @Eamil: 2695062879@qq.com
 */
@RequestMapping(value = "/test")
@RestController
public class TestController {

    /**
     * testService
     */
    @Autowired
    private TestService testService;


    @Autowired
    private RestTemplate restTemplate;

    /**
     * 从路劲中获取值
     * @param id id
     * @return 是否成功
     */
    @GetMapping(value = "/path/{id}")
    public ResponseResult testGet(@PathVariable String id){
//        restTemplate.getForObject("http://localhost:8080/appdemo/formate")
        return testService.path(id);
    }

    /**
     * get提交formdate数据表格
     * @param request form表单
     * @return 是否成功
     */
    @GetMapping(value = "/formdate")
    public ResponseResult testFormdate(@Valid @ModelAttribute TestRequest request){
        return testService.testFormdate(request);
    }

    /**
     * 测试上送json
     * @param request json实体
     * @return 是否成功
     */
    @PostMapping(value = "/post")
    public ResponseResult testPostJson(@Valid @RequestBody TestRequest request){
        return testService.testJson(request);
    }
}
