package com.fengx.springcloud.MyBalance;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * Created by apple on 2020/8/7.
 * 自定义负载均衡的接口
 */
public interface LoadBalancer {
    ServiceInstance getServiceInstance(List<ServiceInstance> serviceInstances);
}
