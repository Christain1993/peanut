package com.christain.peanut.spring_study.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

@Slf4j
public class PeanutBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof PeanutConfig) {
            log.info("======== peanut postprocess , before =========");
            log.info("bean : {} ", bean);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof PeanutConfig) {
            log.info("======== peanut postprocess , after =========");
            log.info("bean : {} ", bean);
        }
        return bean;
    }
}
