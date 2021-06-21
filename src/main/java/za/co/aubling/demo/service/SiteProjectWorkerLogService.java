package za.co.aubling.demo.service;

import org.springframework.stereotype.Service;
import za.co.aubling.demo.dao.SiteProjectWorkerLogRepository;
import za.co.aubling.demo.domain.SiteProjectWorkerLog;
import za.co.aubling.demo.dto.SiteProjectWorkerLogDto;
import za.co.aubling.demo.id.SiteProjectWorkerLogId;
import za.co.aubling.demo.mapper.SiteProjectWorkerLogMapper;

import javax.persistence.IdClass;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@IdClass(SiteProjectWorkerLogId.class)
@Service
public class SiteProjectWorkerLogService {

    private final SiteProjectWorkerLogMapper siteProjectWorkerLogMapper;

    private final SiteProjectWorkerLogRepository siteProjectWorkerLogRepository;

    public SiteProjectWorkerLogService(SiteProjectWorkerLogRepository siteProjectWorkerLogRepository, SiteProjectWorkerLogMapper siteProjectWorkerLogMapper) {
        this.siteProjectWorkerLogRepository = siteProjectWorkerLogRepository;
        this.siteProjectWorkerLogMapper = siteProjectWorkerLogMapper;
    }

    @Transactional
    public SiteProjectWorkerLog addProjectWorkerLog(SiteProjectWorkerLogDto siteProjectWorkerLogDto){
        SiteProjectWorkerLog siteProjectWorkerLog = siteProjectWorkerLogMapper.toEntity(siteProjectWorkerLogDto);
        return siteProjectWorkerLogRepository.save(siteProjectWorkerLog);
    }

    public List<SiteProjectWorkerLog> getProjectWorkerLogs() {
        return siteProjectWorkerLogRepository.findAll();
    }

    public SiteProjectWorkerLog getProjectWorkerLog(Long workerId, Long projectId, Date workDate) {
        Optional<SiteProjectWorkerLog> siteProjectWorkerLog = siteProjectWorkerLogRepository.findById(new SiteProjectWorkerLogId(workerId,projectId,workDate));
        if (!siteProjectWorkerLog.isPresent()) {
            throw new RuntimeException(String.format("Project Worker with id %s does not exist", workerId + " " + projectId + " " + workDate));
        }
        return siteProjectWorkerLog.get();
    }
}
