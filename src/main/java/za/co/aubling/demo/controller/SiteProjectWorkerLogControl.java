package za.co.aubling.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.aubling.demo.service.SiteProjectWorkerLogService;

@RestController
@RequestMapping("/api/projectworkerlog")
public class SiteProjectWorkerLogControl {

    @Autowired
    private SiteProjectWorkerLogService siteProjectWorkerLogService;

    @GetMapping
    public ResponseEntity<String> addSiteProjectWorkerLog(){
        siteProjectWorkerLogService.addSiteProjectWorkerLog();
        return ResponseEntity.ok("Success");
    }
}
