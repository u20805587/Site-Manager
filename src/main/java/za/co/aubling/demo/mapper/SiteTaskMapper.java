package za.co.aubling.demo.mapper;

import org.springframework.stereotype.Component;
import za.co.aubling.demo.domain.SiteTask;
import za.co.aubling.demo.dto.SiteTaskDto;

@Component
public class SiteTaskMapper {
    public SiteTaskDto toDto(SiteTask siteTask) {
        return SiteTaskDto.builder()
                .id(siteTask.getId())
                .name(siteTask.getName())
                .description(siteTask.getDescription())
                .build();
    }

    public SiteTask toEntity(SiteTaskDto siteTaskDto) {
        return SiteTask.builder()
                .id(siteTaskDto.getId())
                .name(siteTaskDto.getName())
                .description(siteTaskDto.getDescription())
                .build();
    }
}
