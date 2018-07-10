package com.jrj.springboot.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyHealthy implements HealthIndicator{
	@Override
	public Health health() {
		return Health.down().withDetail("在家待着尼！！！！！", "down").build();
	}

}
