package com.jwt.special.autoconfig;

import com.jwt.special.component.LoginUserInfo;
import com.jwt.special.service.UserService;
import com.jwt.special.web.LoginInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication(/*exclude = DataSourceAutoConfiguration.class*/)
@EnableTransactionManagement
@EnableScheduling
@MapperScan({"com.jwt.special.dao"})
@ComponentScan({"com.jwt.special.**", "springfox"})
public class BootStrap extends WebMvcConfigurationSupport {
    @Autowired
    private UserService userService;
    @Autowired
    private LoginUserInfo loginUserInfo;

    public static void main(String[] args) {
        SpringApplication.run(BootStrap.class, args);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截器链
        registry.addInterceptor(new LoginInterceptor(userService, loginUserInfo)).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    //放行静态资源
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }
    /** 统一拦截处理 */
    @Bean
    public FilterRegistrationBean testFilterRegistration() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new ParameterFilter());//添加过滤器
        filterRegistrationBean.addUrlPatterns("/*");//设置过滤路径
        filterRegistrationBean.setOrder(1);//设置优先级
        return  filterRegistrationBean;
    }
}

