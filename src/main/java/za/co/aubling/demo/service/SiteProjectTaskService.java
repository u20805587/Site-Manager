package za.co.aubling.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.aubling.demo.dao.SiteProjectTaskRepository;
import za.co.aubling.demo.domain.SiteProject;
import za.co.aubling.demo.domain.SiteProjectTask;
import za.co.aubling.demo.domain.SiteSubTask;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class SiteProjectTaskService {

    @Autowired
    private SiteProjectTaskRepository siteProjectTaskRepository;

    public void addSiteProjectTask(){

        SiteProjectTask siteProjectTask = new SiteProjectTask();


        siteProjectTaskRepository.save(siteProjectTask);
    }
}
