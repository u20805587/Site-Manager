package za.co.aubling.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.aubling.demo.dao.EquipmentRepository;
import za.co.aubling.demo.domain.Equipment;


import java.math.BigDecimal;
import java.util.Date;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    public void addEquipment(){

        Equipment equipment = new Equipment();

        equipment.setEquipmentId(Long.valueOf(20000000));
        equipment.setEquipmentName("Makita Driller");
        equipment.setEquipmentDescription("Very tough power driller");
        equipment.setBrand("Makita");
        equipment.setServiced("Y");
        equipment.setCost(new BigDecimal("800.000001"));
        equipment.setDateAcquired(new Date());
        equipment.setModel("XR-260");
        equipment.setNextServiceDate(new Date());
        equipment.setServiceDate(new Date());
        equipment.setStatus("A");

        equipmentRepository.save(equipment);
    }
}
