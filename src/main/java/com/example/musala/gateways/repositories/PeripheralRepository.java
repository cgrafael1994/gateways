package com.example.musala.gateways.repositories;

import com.example.musala.gateways.entity.Peripheral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeripheralRepository  extends JpaRepository<Peripheral,Integer> {

    Peripheral findByUidEquals(Integer uid);

}
