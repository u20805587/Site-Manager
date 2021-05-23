package za.co.aubling.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.aubling.demo.service.SiteProjectWorkerService;

@RestController
@RequestMapping("/api/projectworker")
public class SiteProjectWorkerControl {

    @Autowired
    private SiteProjectWorkerService siteProjectWorkerService;

    @GetMapping
    public ResponseEntity<String> addSiteProjectWorker(){
        siteProjectWorkerService.addSiteProjectWorker();
        return ResponseEntity.ok("Success");
    }
}
