package za.co.aubling.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.aubling.demo.service.SiteProjectService;

@RestController
@RequestMapping("/api/project")
public class SiteProjectControl {

    @Autowired
    private SiteProjectService siteProjectService;

    @GetMapping
    public ResponseEntity<String> addSiteProject(){
        siteProjectService.addSiteProject();
        return ResponseEntity.ok("Success");
    }
}
