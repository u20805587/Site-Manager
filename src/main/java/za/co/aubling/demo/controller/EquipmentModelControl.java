package za.co.aubling.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.aubling.demo.service.EquipmentModelService;

@RestController
@RequestMapping("/api/equipmentmodel")
public class EquipmentModelControl {

    @Autowired
    private EquipmentModelService equipmentModelService;

    @GetMapping
    public ResponseEntity<String> addEquipmentModel(){
        equipmentModelService.addEquipmentModel();
        return ResponseEntity.ok("Success");
    }
}