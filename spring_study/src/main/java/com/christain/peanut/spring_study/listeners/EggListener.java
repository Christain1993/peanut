package com.christain.peanut.spring_study.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;


@Slf4j
public class EggListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        log.info("egg listener : {}, {} ", event.getSource(), event.getClass().getName());
    }
}
