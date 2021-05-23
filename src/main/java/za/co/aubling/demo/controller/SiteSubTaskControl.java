package za.co.aubling.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.aubling.demo.service.SiteSubTaskService;

@RestController
@RequestMapping("/api/subtask")
public class SiteSubTaskControl {

    @Autowired
    private SiteSubTaskService siteSubTaskService;

    @GetMapping
    public ResponseEntity<String> addSiteSubTask(){
        siteSubTaskService.addSiteSubTask();
        return ResponseEntity.ok("Success");
    }
}
