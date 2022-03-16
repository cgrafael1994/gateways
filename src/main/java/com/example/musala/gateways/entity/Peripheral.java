package com.example.musala.gateways.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;


@Entity
public class Peripheral {

    private Integer uid;
    private String vendor;
    private Date dateCreated;
    private boolean onlineStatus;
    private String serialNumber;
    private Gateway gatewayBySerialNumber;

    @Id
    @Column(name = "UID", nullable = false)
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }


    @Basic
    @Column(name = "VENDOR", nullable = false, length = 100)
    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }


    @Basic
    @Column(name = "DATE_CREATED", nullable = true)
    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Basic
    @Column(name = "ONLINE_STATUS", nullable = false)
    public Boolean getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(Boolean onlineStatus) {
        this.onlineStatus = onlineStatus;
    }


    @Basic
    @Column(name = "SERIAL_NUMBER", nullable = false, length = 100)
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setGatewayBySerialNumber(Gateway gatewayBySerialNumber) {
        this.gatewayBySerialNumber = gatewayBySerialNumber;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }



    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "SERIAL_NUMBER", referencedColumnName = "SERIAL_NUMBER", insertable = false , updatable = false, nullable = false)
    public Gateway getGatewayBySerialNumber() {
        return gatewayBySerialNumber;


    }
}
