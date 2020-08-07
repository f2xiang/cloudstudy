package com.fengx.springcloud.MyBalance;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by apple on 2020/8/7.
 * 自定义轮询算法
 */
@Component
public class RoundBalance implements LoadBalancer {

    private AtomicInteger currentAtomicInteger = new AtomicInteger(0);


    @Override
    public ServiceInstance getServiceInstance(List<ServiceInstance> serviceInstances) {
        int next = currentAtomicInteger.incrementAndGet();
        int index = next % serviceInstances.size();
        return serviceInstances.get(index);
    }


    // 写法2
    private int getCompareAndSet() {
        int current;
        int next;
        do {
            current = currentAtomicInteger.get();
            next = current < Integer.MAX_VALUE? current+1 : 0;
        }while (!currentAtomicInteger.compareAndSet(current, next));
        return next;
    }


}
