package com.yi23.springboot.event.listener;

import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;

/**
 * Before {@link ConfigFileApplicationListener}
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang</a>
 * @see
 * @since
 */
public class BeforeConfigFileApplicationListener implements SmartApplicationListener, Ordered {

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return ApplicationEnvironmentPreparedEvent.class.isAssignableFrom(eventType)
                || ApplicationPreparedEvent.class.isAssignableFrom(eventType);
    }

    @Override
    public boolean supportsSourceType(Class<?> aClass) {
        return true;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationEnvironmentPreparedEvent) {
            ApplicationEnvironmentPreparedEvent environmentPreparedEvent = (ApplicationEnvironmentPreparedEvent) event;
            Environment environment = environmentPreparedEvent.getEnvironment();
            System.out.println("environment.getProperty(\"name\"): " + environment.getProperty("name"));
        }
        if (event instanceof ApplicationPreparedEvent) {

        }
    }

    @Override
    public int getOrder() {
        //比 ConfigFileApplicationListener 优先级高
        return ConfigFileApplicationListener.DEFAULT_ORDER - 1;
    }


}
