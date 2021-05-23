package za.co.aubling.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.aubling.demo.dao.SiteProjectWorkerLogRepository;
import za.co.aubling.demo.domain.SiteProject;
import za.co.aubling.demo.domain.SiteProjectWorkerLog;
import za.co.aubling.demo.domain.SiteWorker;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class SiteProjectWorkerLogService {

    @Autowired
    private SiteProjectWorkerLogRepository siteProjectWorkerLogRepository;

    public void addSiteProjectWorkerLog(){

        SiteProjectWorkerLog siteProjectWorkerLog = new SiteProjectWorkerLog();

        siteProjectWorkerLog.setProjectId(new SiteProject());
        siteProjectWorkerLog.setWorkerId(new SiteWorker());
        siteProjectWorkerLog.setWorkDate(new Date());
        siteProjectWorkerLog.setHours(BigDecimal.valueOf(8));

        siteProjectWorkerLogRepository.save(siteProjectWorkerLog);
    }
}
