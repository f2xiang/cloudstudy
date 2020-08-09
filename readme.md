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


#### openFeign
启动类上，@EnableFeignClients注解

接口上，@FeignClient注解

service写上对应服务名，以及对应的接口地址（provider controller提供出来的地址）。

controller去调用service，通过service到达provider。

实际就是省略了显示的去写restTemplate，

- 超时设置
- 日志打印

#### Hystrix
一般配置在客户端，可以和feign做整合。

##### 服务降级：fallback
    服务器忙，请稍后再试。
    不让客户端等待并返回一个友好的提示。
    例如：程序运行异常，超时，服务熔断触发服务降级，线程池/信号量打满
    
##### 服务熔断 ：break
    到达最大访问量后，拒绝继续访问，并调用服务降级，返回友好提示。

##### 服务限流： limit
    秒杀高并发等操作，严禁一窝蜂过来，大家排队，有序进行

- Hystrix的配置，@HystrixCommand和@HystrixProperty
- 单个方法做处理，以及全局处理，```@DefaultProperties(defaultFallback = "getGlobalFallback")```
- 终极版，service的@feignclient注解上加上fallback=xx.java类。出问题，该类做兜底。



#### Gateway
##### 三大核心概念
    web请求，通过一些匹配条件，到达真正的服务节点。在这个转发的前后做一些精细化的控制。
    而Predicate就是我们的匹配条件，Filter，拦截和过滤，加上目标uri，就可以实现具体的路由了。
- 路由 Route  
- 断言 Predicate
- 过滤 Filter
    
    



