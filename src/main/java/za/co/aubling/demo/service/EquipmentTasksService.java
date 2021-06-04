package za.co.aubling.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.aubling.demo.dao.EquipmentTasksRepository;


@Service
public class EquipmentTasksService {

    @Autowired
    private EquipmentTasksRepository equipmentTasksRepository;

    public void addEquipmentTasks(){

    }
}
