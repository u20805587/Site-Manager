package za.co.aubling.demo.service;

import org.springframework.stereotype.Service;
import za.co.aubling.demo.dao.SiteProjectTaskRepository;
import za.co.aubling.demo.domain.SiteProjectTask;
import za.co.aubling.demo.dto.SiteProjectTaskDto;
import za.co.aubling.demo.id.SiteProjectTaskId;
import za.co.aubling.demo.mapper.SiteProjectTaskMapper;

import javax.persistence.IdClass;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@IdClass(SiteProjectTaskId.class)
@Service
public class SiteProjectTaskService {

    private final SiteProjectTaskMapper siteProjectTaskMapper;

    private final SiteProjectTaskRepository siteProjectTaskRepository;

    public SiteProjectTaskService(SiteProjectTaskRepository siteProjectTaskRepository, SiteProjectTaskMapper siteProjectTaskMapper) {
        this.siteProjectTaskRepository = siteProjectTaskRepository;
        this.siteProjectTaskMapper = siteProjectTaskMapper;
    }

    @Transactional
    public SiteProjectTask addProjectTask(SiteProjectTaskDto siteProjectTaskDto){
        SiteProjectTask siteProjectTask = siteProjectTaskMapper.toEntity(siteProjectTaskDto);
        return siteProjectTaskRepository.save(siteProjectTask);
    }

    public List<SiteProjectTask> getProjectTasks() {
        return siteProjectTaskRepository.findAll();
    }

    public SiteProjectTask getProjectTask(Long subtaskId, Long projectId) {
        Optional<SiteProjectTask> siteProjectTask = siteProjectTaskRepository.findById(new SiteProjectTaskId(subtaskId,projectId));
        if (!siteProjectTask.isPresent()) {
            throw new RuntimeException(String.format("Project Task with id %s does not exist", subtaskId + " " + projectId ));
        }
        return siteProjectTask.get();
    }
}
