package za.co.aubling.demo.service;

import org.springframework.stereotype.Service;
import za.co.aubling.demo.dao.SiteTaskRepository;
import za.co.aubling.demo.domain.SiteTask;
import za.co.aubling.demo.dto.SiteTaskDto;
import za.co.aubling.demo.mapper.SiteTaskMapper;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SiteTaskService {

    private final SiteTaskMapper TaskMapper;

    private final SiteTaskRepository siteTaskRepository;

    public SiteTaskService(SiteTaskRepository siteTaskRepository, SiteTaskMapper TaskMapper) {
        this.siteTaskRepository = siteTaskRepository;
        this.TaskMapper = TaskMapper;
    }

    @Transactional
    public SiteTask addSiteTask(SiteTaskDto siteTaskDto){
        SiteTask siteTask = TaskMapper.toEntity(siteTaskDto);
        return siteTaskRepository.save(siteTask);
    }

    public List<SiteTask> getTasks() {
        return siteTaskRepository.findAll();
    }

    public SiteTask getTask(Long taskId) {
        Optional<SiteTask> task = siteTaskRepository.findById(taskId);
        if (!task.isPresent()) {
            throw new RuntimeException(String.format("Task with id %s does not exist", taskId));
        }
        return task.get();
    }
}
