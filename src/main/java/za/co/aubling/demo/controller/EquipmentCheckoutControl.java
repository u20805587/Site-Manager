package za.co.aubling.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.aubling.demo.service.EquipmentCheckoutService;

@RestController
@RequestMapping("/api/equipmentcheckout")
public class EquipmentCheckoutControl {

    @Autowired
    private EquipmentCheckoutService equipmentCheckoutService;

    @GetMapping
    public ResponseEntity<String> addEquipmentCheckout(){
        equipmentCheckoutService.addEquipmentCheckout();
        return ResponseEntity.ok("Success");
    }
}