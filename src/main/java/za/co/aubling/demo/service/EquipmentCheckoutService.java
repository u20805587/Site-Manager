package za.co.aubling.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.aubling.demo.dao.EquipmentCheckoutRepository;
import za.co.aubling.demo.domain.EquipmentCheckout;


import java.math.BigDecimal;
import java.util.Date;

@Service
public class EquipmentCheckoutService {

    @Autowired
    private EquipmentCheckoutRepository equipmentCheckoutRepository;

    public void addEquipmentCheckout(){

        EquipmentCheckout equipmentCheckout = new EquipmentCheckout();

        equipmentCheckoutRepository.save(equipmentCheckout);
    }
}
