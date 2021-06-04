package za.co.aubling.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.aubling.demo.dao.SiteProjectRepository;
import za.co.aubling.demo.domain.SiteProject;
import za.co.aubling.demo.dto.SiteProjectDto;
import za.co.aubling.demo.mapper.SiteProjectMapper;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class SiteProjectService {

    private final SiteProjectMapper projectMapper;

    private final SiteProjectRepository siteProjectRepository;

    public SiteProjectService(SiteProjectRepository siteProjectRepository, SiteProjectMapper projectMapper) {
        this.siteProjectRepository = siteProjectRepository;
        this.projectMapper = projectMapper;
    }

    @Transactional
    public SiteProject addSiteProject(SiteProjectDto siteProjectDto){
        SiteProject siteProject = projectMapper.toEntity(siteProjectDto);
        return siteProjectRepository.save(siteProject);
    }

    public List<SiteProject> getProjects() {
        return siteProjectRepository.findAll();
    }
}
