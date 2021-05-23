package za.co.aubling.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.aubling.demo.service.EquipmentTasksService;

@RestController
@RequestMapping("/api/equipmenttasks")
public class EquipmentTasksControl {

    @Autowired
    private EquipmentTasksService equipmentTasksService;

    @GetMapping
    public ResponseEntity<String> addEquipmentTasks(){
        equipmentTasksService.addEquipmentTasks();
        return ResponseEntity.ok("Success");
    }
}