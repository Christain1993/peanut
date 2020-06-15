package com.christain.peanut.spring_study.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
     ======== aware , setApplicationContext =========
     回调 setApplicationContext 方法 bean : org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@479cbee5, started on Mon Jun 15 11:03:26 CST 2020
     ======== peanut postprocess , before =========
     bean : PeanutConfig(username=abc, password=123, remark=null, url=null)
     ======== InitializingBean , afterPropertiesSet =========
     回调 initializingBean 方法 bean : PeanutConfig(username=abc, password=123, remark=null, url=null)
     ======== peanut postprocess , after =========
     bean : PeanutConfig(username=abc, password=123, remark=null, url=null)
 *
 *
 * 这个config 的注入, 涉及对象创建的逻辑, 首先是 aware  对象处理器, before 然后是 initialzingBean 中的afterProperties ,然后是象处理器 after
 */
@Slf4j
@Data
public class PeanutConfig implements InitializingBean, ApplicationContextAware {

    private String username;
    private String password;

    private String remark;
    private String url;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("======== InitializingBean , afterPropertiesSet =========");
        log.info("回调 initializingBean 方法 bean : {} ", this);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("======== aware , setApplicationContext =========");
        log.info("回调 setApplicationContext 方法 bean : {} ", applicationContext);
    }
}
