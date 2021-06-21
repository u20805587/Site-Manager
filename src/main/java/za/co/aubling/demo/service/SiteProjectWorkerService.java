package za.co.aubling.demo.service;

import org.springframework.stereotype.Service;
import za.co.aubling.demo.dao.SiteProjectWorkerRepository;
import za.co.aubling.demo.domain.SiteProjectWorker;
import za.co.aubling.demo.dto.SiteProjectWorkerDto;
import za.co.aubling.demo.id.SiteProjectWorkerId;
import za.co.aubling.demo.mapper.SiteProjectWorkerMapper;

import javax.persistence.IdClass;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.io.*;

@IdClass(SiteProjectWorkerId.class)
@Service
public class SiteProjectWorkerService {

    private final SiteProjectWorkerMapper siteProjectWorkerMapper;

    private final SiteProjectWorkerRepository siteProjectWorkerRepository;

    public SiteProjectWorkerService(SiteProjectWorkerRepository siteProjectWorkerRepository, SiteProjectWorkerMapper siteProjectWorkerMapper) {
        this.siteProjectWorkerRepository = siteProjectWorkerRepository;
        this.siteProjectWorkerMapper = siteProjectWorkerMapper;
    }

    @Transactional
    public SiteProjectWorker addProjectWorker(SiteProjectWorkerDto siteProjectWorkerDto){
        System.out.println("Aubrey Test");
        SiteProjectWorker siteProjectWorker = siteProjectWorkerMapper.toEntity(siteProjectWorkerDto);
        System.out.println("Aubrey Test"+siteProjectWorker.getHourlyRate());
        return siteProjectWorkerRepository.save(siteProjectWorker);
    }

    public List<SiteProjectWorker> getProjectWorkers() {
        return siteProjectWorkerRepository.findAll();
    }

    public SiteProjectWorker getProjectWorker(Long workerId, Long projectId) {
        Optional<SiteProjectWorker> siteProjectWorker = siteProjectWorkerRepository.findById(new SiteProjectWorkerId(workerId,projectId));
        if (!siteProjectWorker.isPresent()) {
            throw new RuntimeException(String.format("Project Worker with id %s does not exist", workerId + " " + projectId ));
        }
        return siteProjectWorker.get();
    }
}
