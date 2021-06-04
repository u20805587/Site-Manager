package za.co.aubling.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.aubling.demo.dao.SiteProjectCalendarRepository;
import za.co.aubling.demo.domain.SiteProject;
import za.co.aubling.demo.domain.SiteProjectCalendar;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class SiteProjectCalendarService {

    @Autowired
    private SiteProjectCalendarRepository siteProjectCalendarRepository;

    public void addSiteProjectCalendar(){

        SiteProjectCalendar siteProjectCalendar = new SiteProjectCalendar();



        siteProjectCalendarRepository.save(siteProjectCalendar);
    }
}
