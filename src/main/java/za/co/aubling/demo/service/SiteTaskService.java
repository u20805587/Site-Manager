package za.co.aubling.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.aubling.demo.dao.SiteTaskRepository;
import za.co.aubling.demo.domain.SiteTask;


@Service
public class SiteTaskService {

    @Autowired
    private SiteTaskRepository siteTaskRepository;

    public void addSiteTask(){

        SiteTask siteTask = new SiteTask();
        siteTaskRepository.save(siteTask);
    }
}
