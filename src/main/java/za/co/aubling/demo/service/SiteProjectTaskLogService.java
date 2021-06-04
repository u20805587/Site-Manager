package za.co.aubling.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.aubling.demo.dao.SiteProjectTaskLogRepository;
import za.co.aubling.demo.domain.SiteProject;
import za.co.aubling.demo.domain.SiteProjectTaskLog;
import za.co.aubling.demo.domain.SiteSubTask;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class SiteProjectTaskLogService {

    @Autowired
    private SiteProjectTaskLogRepository siteProjectTaskLogRepository;

    public void addSiteProjectTaskLog(){

        SiteProjectTaskLog siteProjectTaskLog = new SiteProjectTaskLog();


        siteProjectTaskLogRepository.save(siteProjectTaskLog);
    }
}
