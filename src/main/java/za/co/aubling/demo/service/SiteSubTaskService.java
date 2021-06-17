package za.co.aubling.demo.service;

import org.springframework.stereotype.Service;
import za.co.aubling.demo.dao.SiteSubTaskRepository;
import za.co.aubling.demo.domain.SiteSubTask;
import za.co.aubling.demo.dto.SiteSubTaskDto;
import za.co.aubling.demo.mapper.SiteSubTaskMapper;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SiteSubTaskService {

    private final SiteSubTaskMapper SubTaskMapper;

    private final SiteSubTaskRepository siteSubTaskRepository;

    public SiteSubTaskService(SiteSubTaskRepository siteSubTaskRepository, SiteSubTaskMapper SubTaskMapper) {
        this.siteSubTaskRepository = siteSubTaskRepository;
        this.SubTaskMapper = SubTaskMapper;
    }

    @Transactional
    public SiteSubTask addSiteSubTask(SiteSubTaskDto siteSubTaskDto){
        SiteSubTask siteSubTask = SubTaskMapper.toEntity(siteSubTaskDto);
        return siteSubTaskRepository.save(siteSubTask);
    }

    public List<SiteSubTask> getSubTasks() {
        return siteSubTaskRepository.findAll();
    }

    public SiteSubTask getSubTask(Long subTaskId) {
        Optional<SiteSubTask> SubTask = siteSubTaskRepository.findById(subTaskId);
        if (!SubTask.isPresent()) {
            throw new RuntimeException(String.format("SubTask with id %s does not exist", subTaskId));
        }
        return SubTask.get();
    }
}
