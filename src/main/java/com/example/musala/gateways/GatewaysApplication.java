package com.example.musala.gateways;

import com.example.musala.gateways.repositories.PeripheralRepository;
import com.example.musala.gateways.services.GatewayService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@Import(GatewayService.class)
@SpringBootApplication
public class GatewaysApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewaysApplication.class, args);
    }

}
