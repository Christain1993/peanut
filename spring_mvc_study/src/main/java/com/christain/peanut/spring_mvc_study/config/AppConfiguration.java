package com.christain.peanut.spring_mvc_study.config;

import com.christain.peanut.common.domain.Period;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class AppConfiguration {

    // 自定义全局convert , 映射配置文件时 , 可以使用
    // 这个converter 不会处理http 的数据
    @Bean
    public ConversionService conversionService() {
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        Set<Converter> converters = new HashSet<>();
        converters.add(new IntegerToPeriodConverter());
        bean.setConverters(converters);
        bean.afterPropertiesSet();
        return bean.getObject();
    }

    public static class IntegerToPeriodConverter implements Converter<Integer, Period> {
        @Override
        public Period convert(Integer source) {
            Period period = new Period();
            period.setAge(source);
            return period;
        }
    }


}
