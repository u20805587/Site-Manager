package za.co.aubling.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.aubling.demo.dao.SiteProjectRepository;
import za.co.aubling.demo.domain.SiteProject;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class ProjectService {

    @Autowired
    private SiteProjectRepository siteProjectRepository;

    public void addProject(){

        SiteProject siteProject = new SiteProject();

        siteProject.setProjectCost(BigDecimal.valueOf(20000000));
        siteProject.setEndDate(new Date());
        siteProject.setStartDate(new Date());
        siteProject.setDateAcquired(new Date());
        siteProject.setProjectName("Bling Paving");
        siteProject.setProjectDescription("Lining paving in yard");
        siteProject.setEstimatedEndDate(new Date());
        siteProject.setEstimatedStartDate(new Date());
        siteProject.setStatus("Active");
        siteProjectRepository.save(siteProject);
    }
}
