package za.co.aubling.demo.mapper;

import org.springframework.stereotype.Component;
import za.co.aubling.demo.domain.SiteProjectTask;
import za.co.aubling.demo.dto.SiteProjectTaskDto;

@Component
public class SiteProjectTaskMapper {
    public SiteProjectTaskDto toDto(SiteProjectTask siteProjectTask) {
        return SiteProjectTaskDto.builder()
                .subtaskId(siteProjectTask.getSubtaskId())
                .projectId(siteProjectTask.getProjectId())
                .length(siteProjectTask.getLength())
                .height(siteProjectTask.getHeight())
                .width(siteProjectTask.getWidth())
                .unit(siteProjectTask.getUnit())
                .status(siteProjectTask.getStatus())
                .build();
    }

    public SiteProjectTask toEntity(SiteProjectTaskDto siteProjectTaskDto) {
        return SiteProjectTask.builder()
                .subtaskId(siteProjectTaskDto.getSubtaskId())
                .projectId(siteProjectTaskDto.getProjectId())
                .length(siteProjectTaskDto.getLength())
                .height(siteProjectTaskDto.getHeight())
                .width(siteProjectTaskDto.getWidth())
                .unit(siteProjectTaskDto.getUnit())
                .status(siteProjectTaskDto.getStatus())
                .build();
    }
}
