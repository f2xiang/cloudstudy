# SpringCloud 学习
- 简单的order-consumer，payment-provider
- eureka单机版
- eureka集群方式（eureka server url 互相引用）
- Provider集群（端口号不同，服务名相同）
    
> 以上两种集群，这里就是复制了module，修改配置文件。
> 也可直接修改配置文件启动

- eureka可视化界面上显示的名称，以及可以看到ip

- zookeeper

#### CAP原则
- C:一致性 Consistency
- A:可用性 Availability
- P:分区容错性 Partition tolerance

这三个要素最多只能同时实现两点，不可能三者兼顾。
在分布式架构中，必须要满足P，而C和A具体情况做取舍。

- Eureka（自我保护机制）， AP
- Zookeeper、Consul， CP



#### eureka和ribbon
新版本的eureka默认继承了ribbon，
ribbon主要是作用在客户端，作为负载均衡，默认轮询。
自己可以根据需求替换负载规则。

- 根据ribbon的轮询写法，手写LoadBalance算法。