package com.christain.peanut.spring_study.config;

import com.christain.peanut.common.domain.Period;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

//这里好像有个bug , 使用 PropertySource yml  list 注入不进去, prefix 也有问题
//@PropertySource(value = {"classpath:a.yml"})
@ConfigurationProperties(prefix = "peanut")
@Component
@Data
public class PeanutProperties {

    private String name;
    private Integer age;
    private List<String> like;
    private Period period;

}

