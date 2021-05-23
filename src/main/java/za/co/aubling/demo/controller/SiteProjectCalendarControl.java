package za.co.aubling.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.aubling.demo.service.SiteProjectCalendarService;

@RestController
@RequestMapping("/api/projectcalendar")
public class SiteProjectCalendarControl {

    @Autowired
    private SiteProjectCalendarService siteProjectCalendarService;

    @GetMapping
    public ResponseEntity<String> addSiteProjectCalendar(){
        siteProjectCalendarService.addSiteProjectCalendar();
        return ResponseEntity.ok("Success");
    }
}
