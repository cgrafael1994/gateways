package com.example.musala.gateways.services;

import com.example.musala.gateways.entity.Gateway;
import com.example.musala.gateways.entity.Peripheral;
import com.example.musala.gateways.repositories.GatewayRepository;
import com.example.musala.gateways.repositories.PeripheralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class GatewayService {

    @Autowired
    private GatewayRepository gatewayRepository;

    @Autowired
    private PeripheralRepository peripheralRepository;

    public ResponseEntity insertPeripheral(Peripheral peripheral){
        Gateway gatewayTemp=gatewayRepository.findBySerialNumberEquals(peripheral.getSerialNumber());
        if(gatewayTemp==null){
            return new ResponseEntity<>("Dont exist that gateway" , HttpStatus.BAD_REQUEST);
                    }
        else{
            if (peripheralRepository.findByUidEquals(peripheral.getUid())==null){

                if (gatewayTemp.getPeripheralCollection().size()<10){
                    peripheralRepository.save(peripheral);
                    return new ResponseEntity<>("Peripheral saved" , HttpStatus.OK);
                }else{
                        return new ResponseEntity<>("That gateway has 10 peripheral" , HttpStatus.BAD_REQUEST);
                    }
            }
            else{
                return new ResponseEntity<>("There is already a peripheral with that uid" , HttpStatus.BAD_REQUEST);
                }


        }

    }

    public ResponseEntity<String> deletePeripheral (Integer uid){
        if (peripheralRepository.findByUidEquals(uid)==null){
            return new ResponseEntity<>("Peripheral not found" , HttpStatus.BAD_REQUEST);
        }else{
            peripheralRepository.deleteById(uid);
            return new ResponseEntity<>("Peripheral delete" , HttpStatus.OK);
        }

    }




    public ResponseEntity<String> insertGateway(Gateway gateway){
        boolean ipAddressValid=isValidIpAddress(gateway.getIpv4Address());
        if (ipAddressValid) {
                if(gatewayRepository.findBySerialNumberEquals(gateway.getSerialNumber())==null){
                    gatewayRepository.save(gateway);
                    return new ResponseEntity<>("Gateway saved" , HttpStatus.OK);
                }else{
                    return new ResponseEntity<>("There is already a gateway with that serial number" , HttpStatus.BAD_REQUEST);
                }
        }else {
            return new ResponseEntity<>("Invalid Ip address" , HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> deleteGateway (String serialNumber){
        if(gatewayRepository.findBySerialNumberEquals(serialNumber)==null) {
            return new ResponseEntity<>("Gateway not found" , HttpStatus.BAD_REQUEST);
        }else{
            List<Peripheral>peripheralList=peripheralRepository.findAll();
            for (int i = 0; i <peripheralList.size() ; i++) {
                Peripheral peripheralTemp=peripheralList.get(i);
                if(peripheralTemp.getSerialNumber().equalsIgnoreCase(serialNumber)){
                    peripheralRepository.deleteById(peripheralTemp.getUid());
                }
            }
            gatewayRepository.deleteById(serialNumber);
            return new ResponseEntity<>("Gateway delete" , HttpStatus.OK);

        }
       }

    public boolean isValidIpAddress(String ip){
        String zeroTo255="(\\d{1,2}|(0|1)\\" + "d{2}|2[0-4]\\d|25[0-5])";

        String regex=zeroTo255+ "\\."+ zeroTo255+"\\."+zeroTo255+"\\."+zeroTo255;

        Pattern p= Pattern.compile(regex);

        if(ip==null){
            return false;
        }

        Matcher m = p.matcher(ip);
        return m.matches();
    }
}
