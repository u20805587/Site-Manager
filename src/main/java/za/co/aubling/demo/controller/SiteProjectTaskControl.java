package za.co.aubling.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.aubling.demo.service.SiteProjectTaskService;

@RestController
@RequestMapping("/api/projecttask")
public class SiteProjectTaskControl {

    @Autowired
    private SiteProjectTaskService siteProjectTaskService;

    @GetMapping
    public ResponseEntity<String> addSiteProjectTask(){
        siteProjectTaskService.addSiteProjectTask();
        return ResponseEntity.ok("Success");
    }
}
