package net.cnki.service;

import lombok.extern.log4j.Log4j2;
import net.cnki.controller.test.TestRequest;
import net.cnki.dao.ProjectInfoPoMapper;
import net.cnki.dao.po.ProjectInfoPo;
import net.cnki.service.test.TestService;
import net.cnki.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author: tianjl
 * @Date: 2021/5/18 17:06
 * @Eamil: 2695062879@qq.com
 */
@Log4j2
@Service
public class TestServiceImpl implements TestService {


    /**
     * 操作数据库
     */
    @Autowired
    private ProjectInfoPoMapper projectInfoPoMapper;

    /**
     * 从路劲中获取
     * @param id id
     * @return 是否成功
     */
    @Override
    public ResponseResult path(String id) {
        Example example = new Example(ProjectInfoPo.class);
        example.createCriteria().andEqualTo("id",1);
        List<ProjectInfoPo> list = projectInfoPoMapper.selectByExample(example);
        return ResponseResult.success(list);
    }

    /**
     * 处理form表单
     * @param request 表单提交的内容
     * @return 是否成功
     */
    @Override
    public ResponseResult testFormdate(TestRequest request) {
        return ResponseResult.success(true);
    }

    /**
     * 上送json是否成功
     * @param request 请求体
     * @return 是否会成功
     */
    @Override
    public ResponseResult testJson(TestRequest request) {
        return ResponseResult.success(true);
    }
}
