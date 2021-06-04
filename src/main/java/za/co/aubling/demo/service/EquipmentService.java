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


        equipmentRepository.save(equipment);
    }
}
