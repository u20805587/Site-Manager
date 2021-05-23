package za.co.aubling.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.aubling.demo.service.SiteTaskService;

@RestController
@RequestMapping("/api/task")
public class SiteTaskControl {

    @Autowired
    private SiteTaskService siteTaskService;

    @GetMapping
    public ResponseEntity<String> addSiteTask(){
        siteTaskService.addSiteTask();
        return ResponseEntity.ok("Success");
    }
}
