package za.co.aubling.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.aubling.demo.dao.EquipmentTasksRepository;


@Service
public class EquipmentTasksService {

    @Autowired
    private EquipmentTasksRepository equipmentTasksRepository;

    public void addSiteWorker(){

        za.co.aubling.demo.domain.EquipmentTasks taskEquipmentType = new za.co.aubling.demo.domain.EquipmentTasks();

        taskEquipmentType.setTaskId(Long.valueOf(2000000));
        taskEquipmentType.setEquipmentID(Long.valueOf(2000000));

        equipmentTasksRepository.save(taskEquipmentType);
    }
}
