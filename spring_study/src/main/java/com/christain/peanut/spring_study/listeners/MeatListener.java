package com.christain.peanut.spring_study.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MeatListener {

    /**
     * 使用注解形式, 添加监听器,
     * 在容器扫描完bean 后就可以接收事件了,
     * 接收ContextRefreshedEvent 及之后的事件 , spi 是最快的, 注解第二块, 创建完容器, 添加监听器, 第三快
     * @param event
     */
    @EventListener
    public void firstListener(ApplicationEvent event){
        log.info("meat listener : {}, {} ", event.getSource(), event.getClass().getName());
    }
}
