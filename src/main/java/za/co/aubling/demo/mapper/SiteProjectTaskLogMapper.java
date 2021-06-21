package za.co.aubling.demo.mapper;

import org.springframework.stereotype.Component;
import za.co.aubling.demo.domain.SiteProjectTaskLog;
import za.co.aubling.demo.dto.SiteProjectTaskLogDto;

@Component
public class SiteProjectTaskLogMapper {
    public SiteProjectTaskLogDto toDto(SiteProjectTaskLog siteProjectTaskLog) {
        return SiteProjectTaskLogDto.builder()
                .subtaskId(siteProjectTaskLog.getSubtaskId())
                .projectId(siteProjectTaskLog.getProjectId())
                .workDate(siteProjectTaskLog.getWorkDate())
                .length(siteProjectTaskLog.getLength())
                .height(siteProjectTaskLog.getHeight())
                .width(siteProjectTaskLog.getWidth())
                .build();
    }

    public SiteProjectTaskLog toEntity(SiteProjectTaskLogDto siteProjectTaskLogDto) {
        return SiteProjectTaskLog.builder()
                .subtaskId(siteProjectTaskLogDto.getSubtaskId())
                .projectId(siteProjectTaskLogDto.getProjectId())
                .workDate(siteProjectTaskLogDto.getWorkDate())
                .length(siteProjectTaskLogDto.getLength())
                .height(siteProjectTaskLogDto.getHeight())
                .width(siteProjectTaskLogDto.getWidth())
                .build();
    }
}
