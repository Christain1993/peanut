package com.christain.peanut.spring_study.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.type.AnnotationMetadata;

import java.util.HashSet;
import java.util.Set;

@Configuration
@Import({AppConfiguration.Registrar.class})
public class AppConfiguration {

    // 自定义全局convert , 映射配置文件时 , 可以使用
    @Bean
    public ConversionService conversionService() {
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        Set<Converter> converters = new HashSet<>();
        converters.add(new IntegerToPeriodConverter());
        bean.setConverters(converters);
        bean.afterPropertiesSet();
        return bean.getObject();
    }

    @Bean
    public PeanutConfig registerPeanutConfig(){
        PeanutConfig peanutConfig = new PeanutConfig();
        peanutConfig.setUsername("abc");
        peanutConfig.setPassword("123");
        return peanutConfig;
    }

    /**
     * 这个是常见的注册器, 第三方框架整合进spring时, 很多都会用到这个类 , 可以将bean 注册到 容器中
     */
    static class Registrar implements ImportBeanDefinitionRegistrar {

        private static final String BEAN_NAME = "peanutPostProcessor";

        @Override
        public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
                                            BeanDefinitionRegistry registry) {
            if (!registry.containsBeanDefinition(BEAN_NAME)) {
                GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
                beanDefinition.setBeanClass(PeanutBeanPostProcessor.class);
                // 这个是啥意思
                beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
                // We don't need this one to be post processed otherwise it can cause a
                // cascade of bean instantiation that we would rather avoid.
                beanDefinition.setSynthetic(true);
                registry.registerBeanDefinition(BEAN_NAME, beanDefinition);
            }
        }

    }
}
