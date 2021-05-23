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

        equipmentCheckout.setEquipmentId(Long.valueOf(20000000));
        equipmentCheckout.setCheckoutDate(new Date());
        equipmentCheckout.setDateAcquired(new Date());
        equipmentCheckout.setProjectId(Long.valueOf(20000000));
        equipmentCheckout.setReturned("N");
        equipmentCheckout.setReferenceNumber(Long.valueOf(2222222));
        equipmentCheckout.setReturnDate(new Date());
        equipmentCheckout.setWorkerId(Long.valueOf(20000000));

        equipmentCheckoutRepository.save(equipmentCheckout);
    }
}
