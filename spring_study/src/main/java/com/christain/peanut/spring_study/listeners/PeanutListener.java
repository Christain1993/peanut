package com.christain.peanut.spring_study.listeners;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;

/**
 * 自定义监听器, 这个监听器是系统级别的监听器,
 * 可以在容器创建过程中, 做些事情
 */
public class PeanutListener implements SmartApplicationListener {

    /**
     * 继承的是smartApplicationListener 可以监听系统的事件 ,
     * 参考 configFileApplicationListener
     * @param eventType
     * @return
     */
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return ApplicationEnvironmentPreparedEvent.class.isAssignableFrom(eventType)
                || ApplicationPreparedEvent.class.isAssignableFrom(eventType);
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("自定义监听器接收到事件");
        System.out.println(event.getClass().getName());

    }
}
