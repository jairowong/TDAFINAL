package Gateway.MSGateway.routes;

package com.example.gateway.routes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@Configuration
public class ApiGatewayRoutes {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/api/usuario/**")
                            .uri("lb://MS-USUARIO"))  // Ruta al servicio de usuarios
                .route(r -> r.path("/api/producto/**")
                            .uri("lb://MS-PRODUCTO"))  // Ruta al servicio de productos
                .build();
    }
}
