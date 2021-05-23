package za.co.aubling.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.aubling.demo.service.EquipmentTypeService;

@RestController
@RequestMapping("/api/equipmenttype")
public class EquipmentTypeControl {

    @Autowired
    private EquipmentTypeService equipmentTypeService;

    @GetMapping
    public ResponseEntity<String> addEquipmentType(){
        equipmentTypeService.addEquipmentType();
        return ResponseEntity.ok("Success");
    }
}