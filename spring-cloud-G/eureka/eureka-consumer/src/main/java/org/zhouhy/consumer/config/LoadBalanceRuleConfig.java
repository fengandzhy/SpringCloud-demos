package org.zhouhy.consumer.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LoadBalanceRuleConfig {
    
    @Bean
    public IRule ribbonRule(){
        return new RandomRule(); 
    }
}
