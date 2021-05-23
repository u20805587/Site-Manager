package za.co.aubling.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.aubling.demo.dao.SiteSubTaskRepository;
import za.co.aubling.demo.domain.SiteSubTask;
import za.co.aubling.demo.domain.SiteTask;

import java.math.BigDecimal;

@Service
public class SiteSubTaskService {

    @Autowired
    private SiteSubTaskRepository siteSubTaskRepository;

    public void addSiteSubTask(){

        SiteSubTask siteSubTask = new SiteSubTask();

        siteSubTask.setSubTaskId(Long.valueOf(20000000));
        siteSubTask.setTaskId(new SiteTask());
        siteSubTask.setSubTaskName("Brick Laying");
        siteSubTask.setSubTaskDescription("Laying Bricks On Ground with Pattern");
        siteSubTask.setCubicMeterCost(null);
        siteSubTask.setMeterCost(null);
        siteSubTask.setSquareMeterCost(BigDecimal.valueOf(200));

        siteSubTaskRepository.save(siteSubTask);
    }
}
