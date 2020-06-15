package com.christain.peanut.spring_study.initializer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;


@Slf4j
public class PeanutInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
      log.info("自定义初始化器, 打印容器对象 {} " , applicationContext);
    }
}
