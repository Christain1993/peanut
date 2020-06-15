package com.christain.peanut.spring_study.listeners;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * 用户级别的监听器
 * 写在 spi 文件里
 */
public class TomatoListener implements ApplicationListener<TomatoListener.TomatoEvent> {


    @Override
    public void onApplicationEvent(TomatoEvent event) {
        Object source = event.getSource();
        System.out.println("用户监听");
        System.out.println(source);
    }

    public static class TomatoEvent extends ApplicationEvent {

        /**
         * Create a new ApplicationEvent.
         *
         * @param source the object on which the event initially occurred (never {@code null})
         */
        public TomatoEvent(Object source) {
            super(source);
        }
    }
}
