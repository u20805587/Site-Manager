package za.co.aubling.demo.mapper;

import org.springframework.stereotype.Component;
import za.co.aubling.demo.domain.SiteProject;
import za.co.aubling.demo.dto.SiteProjectDto;

@Component
public class SiteProjectMapper {

    public SiteProjectDto toDto(SiteProject siteProject) {
        return SiteProjectDto.builder()
                .id(siteProject.getId())
                .name(siteProject.getName())
                .description(siteProject.getDescription())
                .estimatedCost(siteProject.getEstimatedCost())
                .projectCost(siteProject.getProjectCost())
                .startDate(siteProject.getEstimatedStartDate())
                .estimatedStartDate(siteProject.getEstimatedStartDate())
                .endDate(siteProject.getEndDate())
                .startDate(siteProject.getStartDate())
                .status(siteProject.getStatus())
                .defaultDailyHours(siteProject.getDefaultDailyHours())
                .maximumAllowedHours(siteProject.getMaximumAllowedHours())
                .estimatedEndDate(siteProject.getEstimatedEndDate())
                .notes(siteProject.getNotes())
                .acquiredDate(siteProject.getDateAcquired())
                .build();
    }

    public SiteProject toEntity(SiteProjectDto siteProjectDto) {
        return SiteProject.builder()
                .id(siteProjectDto.getId())
                .name(siteProjectDto.getName())
                .description(siteProjectDto.getDescription())
                .estimatedCost(siteProjectDto.getEstimatedCost())
                .projectCost(siteProjectDto.getProjectCost())
                .startDate(siteProjectDto.getEstimatedStartDate())
                .estimatedStartDate(siteProjectDto.getEstimatedStartDate())
                .endDate(siteProjectDto.getEndDate())
                .startDate(siteProjectDto.getStartDate())
                .status(siteProjectDto.getStatus())
                .defaultDailyHours(siteProjectDto.getDefaultDailyHours())
                .maximumAllowedHours(siteProjectDto.getMaximumAllowedHours())
                .estimatedEndDate(siteProjectDto.getEstimatedEndDate())
                .notes(siteProjectDto.getNotes())
                .dateAcquired(siteProjectDto.getAcquiredDate())
                .build();
    }
}
