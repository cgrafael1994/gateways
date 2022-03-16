package com.example.musala.gateways.repositories;

import com.example.musala.gateways.entity.Gateway;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GatewayRepository extends JpaRepository<Gateway,String> {

        Gateway findBySerialNumberEquals(String serialNumber);
}
