package za.co.aubling.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.aubling.demo.service.SiteWorkerCategoryService;

@RestController
@RequestMapping("/api/corkercategory")
public class SiteWorkerCategoryControl {

    @Autowired
    private SiteWorkerCategoryService siteWorkerCategoryService;

    @GetMapping
    public ResponseEntity<String> addSiteWorkerCategory(){
        siteWorkerCategoryService.addSiteWorkerCategory();
        return ResponseEntity.ok("Success");
    }
}
