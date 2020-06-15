package com.christain.peanut.spring_study;

import com.christain.peanut.spring_study.config.PeanutConfig;
import com.christain.peanut.spring_study.config.PeanutProperties;
import com.christain.peanut.spring_study.listeners.EggListener;
import com.christain.peanut.spring_study.listeners.TomatoListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.env.Environment;


@Slf4j
@SpringBootApplication
public class PeanutSpringApplication implements EnvironmentAware , ApplicationRunner {

    /**
     * 配置文件
     * 优先级
     * file: /config
     * file: /
     * classpath: /config
     * classpath: /
     *
     * 格式优先级,
     * properties
     * yml
     *
     * profile 优先级
     * spring.profiles.active=prod,dev 后边的优先级比较高,
     * dev 比 prod 高, 如果是  spring.profiles.active=dev,prod 则 prod 比较高
     *
     * 所有的配置文件都会加载, 优先级由高到低依次取数, 如果取到了, 则返回
     *
     */
    private Environment environment;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(PeanutSpringApplication.class);
        // 创建容器之后, 再添加的监听器, 只能监听用户自定义的事件, 因为系统的事件已经执行完了, 使用spi 注入的比较早
        context.addApplicationListener(new EggListener());
        TomatoListener.TomatoEvent tomatoEvent = new TomatoListener.TomatoEvent("这是一个用户的listener");
        context.publishEvent(tomatoEvent);

        PeanutConfig peanutConfig = context.getBean(PeanutConfig.class);
        log.info("peanutConfig {}", peanutConfig);

        log.info("peanutProperties {} ", context.getBean(PeanutProperties.class));
        ConversionService bean = (ConversionService) context.getBean("conversionService");
        System.out.println(bean);


    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("===================runner===================");
        log.info(" runner {} ",environment.getProperty("peanut.name"));
        log.info(" runner {} ",environment.getProperty("peanut.age"));
        log.info(" runner {} ",environment.getProperty("peanut.address"));
    }
}
