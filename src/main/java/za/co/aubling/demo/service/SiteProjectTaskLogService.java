package za.co.aubling.demo.service;

import org.springframework.stereotype.Service;
import za.co.aubling.demo.dao.SiteProjectTaskLogRepository;
import za.co.aubling.demo.domain.SiteProjectTaskLog;
import za.co.aubling.demo.dto.SiteProjectTaskLogDto;
import za.co.aubling.demo.id.SiteProjectTaskLogId;
import za.co.aubling.demo.mapper.SiteProjectTaskLogMapper;

import javax.persistence.IdClass;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@IdClass(SiteProjectTaskLogId.class)
@Service
public class SiteProjectTaskLogService {

    private final SiteProjectTaskLogMapper siteProjectTaskLogMapper;

    private final SiteProjectTaskLogRepository siteProjectTaskLogRepository;

    public SiteProjectTaskLogService(SiteProjectTaskLogRepository siteProjectTaskLogRepository, SiteProjectTaskLogMapper siteProjectTaskLogMapper) {
        this.siteProjectTaskLogRepository = siteProjectTaskLogRepository;
        this.siteProjectTaskLogMapper = siteProjectTaskLogMapper;
    }

    @Transactional
    public SiteProjectTaskLog addProjectTaskLog(SiteProjectTaskLogDto siteProjectTaskLogDto){
        SiteProjectTaskLog siteProjectTaskLog = siteProjectTaskLogMapper.toEntity(siteProjectTaskLogDto);
        return siteProjectTaskLogRepository.save(siteProjectTaskLog);
    }

    public List<SiteProjectTaskLog> getProjectTaskLogs() {
        return siteProjectTaskLogRepository.findAll();
    }

    public SiteProjectTaskLog getProjectTaskLog(Long subtaskId, Long projectId, Date workDate) {
        Optional<SiteProjectTaskLog> siteProjectTaskLog = siteProjectTaskLogRepository.findById(new SiteProjectTaskLogId(subtaskId,projectId,workDate));
        if (!siteProjectTaskLog.isPresent()) {
            throw new RuntimeException(String.format("Project Worker with id %s does not exist", subtaskId + " " + projectId ));
        }
        return siteProjectTaskLog.get();
    }
}
