package com.fengx.balancerule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by apple on 2020/8/7.
 * Ribbon默认的负载均衡规则是轮训，
 * 我们可以进行替换，但是不能和springboot启动类放在同一个包名下。
 * 要在启动类上关联到这个规则，不然找不到了。
 *
 */
@Configuration
public class BalanceRule {

    @Bean
    public IRule getRule() {
        // 定义为随机
        return new RandomRule();
    }
}
