package com.christain.peanut.spring_study.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;

@Slf4j
@Component
public class PeanutRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        YamlPropertySourceLoader loader = new YamlPropertySourceLoader();
        List<PropertySource<?>> peanutyml = loader.load("a", new ClassPathResource("a.yml"));
        log.info("============== load ============");
        PropertySource<?> propertySource = peanutyml.stream().findFirst().get();
        LinkedHashMap<String,Object> source = (LinkedHashMap)propertySource.getSource();
        source.entrySet().forEach(x->log.info("{} : {} ",x.getKey(),x.getValue() ));


        // 如何从 PropertySource 封装到 对象 的, 待研究


    }
}
