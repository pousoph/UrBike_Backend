package co.edu.unbosque.urbike.viajeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ViajeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ViajeServiceApplication.class, args);
    }

}
