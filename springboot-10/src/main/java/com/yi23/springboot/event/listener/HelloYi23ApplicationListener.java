package com.yi23.springboot.event.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;

/**
 * hello yi23 {@link ApplicationListener} 监听 {@link ContextRefreshedEvent}事件
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang</a>
 * @see
 * @since
 */
public class HelloYi23ApplicationListener
        implements ApplicationListener<ContextRefreshedEvent>,Ordered {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        System.out.printf("上下文内容id:%s,timestamp:%s.\r\n",
                event.getApplicationContext().getId(), event.getTimestamp());

    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
