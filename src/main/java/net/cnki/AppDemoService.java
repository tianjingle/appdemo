package net.cnki;

import net.cnki.utils.MyMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author: tianjl
 * @Date: 2021/5/18 16:10
 * @Eamil: 2695062879@qq.com
 */
@SpringBootApplication
@MapperScan(basePackages = {"net.cnki.dao"}, markerInterface = MyMapper.class)
public class AppDemoService {

    /**
     * 容器启动
     * @param args 命令行中的参数
     */
    public static void main(String[] args) {
        SpringApplication.run(AppDemoService.class,args);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
