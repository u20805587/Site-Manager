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
                .estimatedCost(siteProject.getProjectCost())
                .startDate(siteProject.getEstimatedStartDate())
                .estimatedStartDate(siteProject.getEstimatedStartDate())
                .endDate(siteProject.getEstimatedEndDate())
                .estimatedEndDate(siteProject.getEstimatedEndDate())
                .notes(siteProject.getNotes())
                .build();
    }

    public SiteProject toEntity(SiteProjectDto siteProjectDto) {
        return SiteProject.builder()
                .id(siteProjectDto.getId())
                .name(siteProjectDto.getName())
                .description(siteProjectDto.getDescription())
                .projectCost(siteProjectDto.getEstimatedCost())
                .dateAcquired(siteProjectDto.getAcquiredDate())
                .startDate(siteProjectDto.getStartDate())
                .estimatedStartDate(siteProjectDto.getEstimatedStartDate())
                .estimatedEndDate(siteProjectDto.getEstimatedEndDate())
                .endDate(siteProjectDto.getEndDate())
                .status(siteProjectDto.getStatus())
                .notes(siteProjectDto.getNotes())
                .build();
    }
}
