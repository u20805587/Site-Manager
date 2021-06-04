package za.co.aubling.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.aubling.demo.dao.SiteProjectWorkerRepository;
import za.co.aubling.demo.domain.SiteProject;
import za.co.aubling.demo.domain.SiteProjectWorker;
import za.co.aubling.demo.domain.SiteWorker;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class SiteProjectWorkerService {

    @Autowired
    private SiteProjectWorkerRepository siteProjectWorkerRepository;

    public void addSiteProjectWorker(){

        SiteProjectWorker siteProjectWorker = new SiteProjectWorker();


        siteProjectWorkerRepository.save(siteProjectWorker);
    }
}
