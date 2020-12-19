package com.young.springcloud.lb;

import java.util.List;
import org.springframework.cloud.client.ServiceInstance;

/**
 * @description:
 * @author: Young
 * @create: 2020-12-19 22:55
 **/

public interface LoadBalancer {

    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
