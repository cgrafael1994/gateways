package com.example.musala.gateways.controllers;

import com.example.musala.gateways.entity.Gateway;
import com.example.musala.gateways.entity.Peripheral;
import com.example.musala.gateways.repositories.GatewayRepository;
import com.example.musala.gateways.services.GatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class GatewayController {


    @Autowired
    private GatewayRepository gatewayRepository;

    @Autowired
    private GatewayService gatewayService;

    @GetMapping("/gateways")
    public List<Gateway> getGateways() {
        return gatewayRepository.findAll();
    }


    @PostMapping("/gateways")
    public ResponseEntity<String> createGateway(@RequestBody Gateway gateway) {
        return gatewayService.insertGateway(gateway);
    }

    @GetMapping("/gateways/{serialNumber}")
    public Optional<Gateway> findGatewayById(@PathVariable String serialNumber) {
        return gatewayRepository.findById(serialNumber);
    }

    @PostMapping("/gateways/peripheral")
    public ResponseEntity<String> createPeripheral (@RequestBody Peripheral peripheral){
         return gatewayService.insertPeripheral(peripheral);
    }

    @DeleteMapping("/peripheral/{uid}")
    public ResponseEntity<String> deletePeripheral (@PathVariable Integer uid){
       return gatewayService.deletePeripheral(uid);
    }

    @DeleteMapping("/gateways/{serialNumber}")
    public ResponseEntity<String> deleteGateway (@PathVariable String serialNumber){
        return gatewayService.deleteGateway(serialNumber);
    }
}
