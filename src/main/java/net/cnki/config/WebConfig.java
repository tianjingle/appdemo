package net.cnki.config;

import net.cnki.filter.LoginInterceptor;
import net.cnki.filter.MyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 * spring Mvc配置
 * @Author: tianjl
 * @Date: 2021/5/18 17:12
 * @Eamil: 2695062879@qq.com
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 拦截器
     */
    @Autowired
    private LoginInterceptor loginInterceptor;

    /**
     * 过滤器
     */
    @Autowired
    private MyFilter myFilter;

    @Bean
    public FilterRegistrationBean testFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(myFilter);
        registration.addUrlPatterns("/*");
        registration.setName("myFilter");
        return registration;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 过滤基本权限
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns(
                        "/**/**",
                        "/**/**/**",
                        "/**/**/**/**")
                .excludePathPatterns(
                        "/admin/login","/static/**");
    }


    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry.addMapping("/**/**")
                // 只允许本地的9000端口访问
                .allowedOrigins("*")
                // 允许发送Cookie
                .allowCredentials(true)
                // 允许所有方法
                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD");
        corsRegistry.addMapping("/**/**/**")
                // 只允许本地的9000端口访问
                .allowedOrigins("*")
                // 允许发送Cookie
                .allowCredentials(true)
                // 允许所有方法
                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD");
    }

    /**
     * SpringBoot url不区分大小写
     * @param configurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        AntPathMatcher matcher = new AntPathMatcher();
        matcher.setCaseSensitive(false);
        configurer.setPathMatcher(matcher);
    }


    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        return lci;
    }


}
