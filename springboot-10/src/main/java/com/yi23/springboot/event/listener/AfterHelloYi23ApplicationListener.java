package com.yi23.springboot.event.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * after hello yi23 {@link ApplicationListener} 监听 {@link ContextRefreshedEvent}事件
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang</a>
 * @see
 * @since
 */
@Order(Ordered.LOWEST_PRECEDENCE)
public class AfterHelloYi23ApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.printf("After 上下文内容id:%s,timestamp:%s.",
                event.getApplicationContext().getId(), event.getTimestamp());

    }
}
