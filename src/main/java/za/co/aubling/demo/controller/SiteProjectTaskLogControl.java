package za.co.aubling.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.aubling.demo.service.SiteProjectTaskLogService;

@RestController
@RequestMapping("/api/projecttaskLog")
public class SiteProjectTaskLogControl {

    @Autowired
    private SiteProjectTaskLogService siteProjectTaskLogService;

    @GetMapping
    public ResponseEntity<String> addSiteProjectTaskLog(){
        siteProjectTaskLogService.addSiteProjectTaskLog();
        return ResponseEntity.ok("Success");
    }
}
