package org.bob.spring.cloud.api.gateway.conf;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by Bob Jiang on 2017/9/21.
 */
@Configuration
public class FallbackConfig {

    @Bean
    public ZuulFallbackProvider userServiceFallbackProvider() {
        return new FallbackProvider() {
            @Override
            public String getRoute() {
                return "user-service";
            }
        };
    }

    @Bean
    public ZuulFallbackProvider orderServiceFallbackProvider() {
        return new FallbackProvider() {
            @Override
            public String getRoute() {
                return "order-service";
            }
        };
    }

}
