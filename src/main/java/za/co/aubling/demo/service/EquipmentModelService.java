package za.co.aubling.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.aubling.demo.dao.EquipmentModelRepository;
import za.co.aubling.demo.domain.EquipmentModel;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class EquipmentModelService {

    @Autowired
    private EquipmentModelRepository equipmentModelRepository;

    public void addEquipmentModel(){

        EquipmentModel equipmentModel = new EquipmentModel();

       equipmentModel.setModel("XR-260");
       equipmentModel.setBrand("Makita");
       equipmentModel.setType("Cordless");
       equipmentModel.setYear("2021");

       equipmentModelRepository.save(equipmentModel);
    }
}
