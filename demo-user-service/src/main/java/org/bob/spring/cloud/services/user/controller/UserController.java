package org.bob.spring.cloud.services.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Bob Jiang on 2017/9/19.
 */
@RestController
public class UserController {

    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/user/{id}")
    public String get(@PathVariable("id") Integer id) {
        ServiceInstance instance = client.getLocalServiceInstance();

        if (instance.getPort() == 8081) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String result = "get user, id: " + id + ". host: " + instance.getHost() + ", service_id: " + instance.getServiceId() + ", port: " + instance.getPort();
        System.out.println(result);
        return result;
    }

}
