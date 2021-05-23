package za.co.aubling.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.aubling.demo.service.SiteWorkerService;

@RestController
@RequestMapping("/api/worker")
public class SiteWorkerControl {

    @Autowired
    private SiteWorkerService siteWorkerService;

    @GetMapping
    public ResponseEntity<String> addSiteWorker(){
        siteWorkerService.addSiteWorker();
        return ResponseEntity.ok("Success");
    }
}
