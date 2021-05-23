package za.co.aubling.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.aubling.demo.dao.SiteWorkerRepository;
import za.co.aubling.demo.domain.SiteWorker;
import za.co.aubling.demo.domain.SiteWorkerCategory;

import java.math.BigDecimal;
import java.util.Date;


@Service
public class SiteWorkerService {

    @Autowired
    private SiteWorkerRepository siteWorkerRepository;

    public void addSiteWorker(){

        SiteWorker siteWorker = new SiteWorker();

        siteWorker.setWorkerId(Long.valueOf(2000000));
        siteWorker.setHourlyRate(BigDecimal.valueOf(200));
        siteWorker.setWorkerCatId(new SiteWorkerCategory());
        siteWorker.setAddressLine1("Makgobaskloof");
        siteWorker.setAddressLine2(null);
        siteWorker.setAddressLine3(null);
        siteWorker.setBirthDate(new Date());
        siteWorker.setContactNumber("0761133391");
        siteWorker.setGender("M");
        siteWorker.setIdNumber("860507565555");
        siteWorker.setMiddleName("Lucas");
        siteWorker.setName("Aubrey");
        siteWorker.setNationality("SA");
        siteWorker.setPostalCode("0187");
        siteWorker.setStateCode("SA");
        siteWorker.setSurname("Lengwate");

        siteWorkerRepository.save(siteWorker);
    }
}
