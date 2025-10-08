package co.edu.unbosque.urbike.notificacionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NotificacionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificacionServiceApplication.class, args);
    }

}
