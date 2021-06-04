package za.co.aubling.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.aubling.demo.dao.SiteWorkerCategoryRepository;
import za.co.aubling.demo.domain.SiteWorkerCategory;

@Service
public class SiteWorkerCategoryService {

    @Autowired
    private SiteWorkerCategoryRepository siteWorkerCategoryRepository;

    public void addSiteWorkerCategory(){

        SiteWorkerCategory siteWorkerCategory = new SiteWorkerCategory();


        siteWorkerCategoryRepository.save(siteWorkerCategory);
    }
}
