package com.example.musala.gateways.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

import javax.persistence.*;
import java.util.Collection;


@Entity
public class Gateway {

    private String serialNumber;
    private String name;
    private String ipv4Address;
    private Collection<Peripheral>peripheralCollection;


    @Id
    @Column(name = "SERIAL_NUMBER", nullable = false)
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }


    @Basic
    @Column(name = "NAME", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Basic
    @Column(name = "IPV4ADDRESS", nullable = false, length = 100)
    public String getIpv4Address() {
        return ipv4Address;
    }

    public void setIpv4Address(String ipv4Address) {
        this.ipv4Address = ipv4Address;
    }

    @OneToMany(mappedBy = "gatewayBySerialNumber")
    public Collection<Peripheral> getPeripheralCollection() {
        return peripheralCollection;
    }

    public void setPeripheralCollection(Collection<Peripheral> peripheralCollection) {
        this.peripheralCollection = peripheralCollection;
    }
}
