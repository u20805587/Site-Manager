package za.co.aubling.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.aubling.demo.service.EquipmentService;

@RestController
@RequestMapping("/api/equipment")
public class EquipmentControl {

    @Autowired
    private EquipmentService equipmentService;

    @GetMapping
    public ResponseEntity<String> addEquipment(){
        equipmentService.addEquipment();
        return ResponseEntity.ok("Success");
    }
}