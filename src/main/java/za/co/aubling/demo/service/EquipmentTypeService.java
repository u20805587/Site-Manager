package za.co.aubling.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.aubling.demo.dao.EquipmentTypeRepository;
import za.co.aubling.demo.domain.EquipmentType;

@Service
public class EquipmentTypeService {

    @Autowired
    private EquipmentTypeRepository equipmentTypeRepository;

    public void addEquipmentType(){

        EquipmentType equipmentType = new EquipmentType();

       equipmentType.setType("Cordless");
       equipmentType.setDescription("Cordless Power Tool");

       equipmentTypeRepository.save(equipmentType);
    }
}
