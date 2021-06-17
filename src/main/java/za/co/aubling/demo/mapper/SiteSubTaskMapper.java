package za.co.aubling.demo.mapper;

import org.springframework.stereotype.Component;
import za.co.aubling.demo.domain.SiteSubTask;
import za.co.aubling.demo.dto.SiteSubTaskDto;

@Component
public class SiteSubTaskMapper {
    public SiteSubTaskDto toDto(SiteSubTask siteSubTask) {
        return SiteSubTaskDto.builder()
                .id(siteSubTask.getId())
                .siteTask(siteSubTask.getSiteTask())
                .subTaskName(siteSubTask.getSubTaskName())
                .subTaskDescription(siteSubTask.getSubTaskDescription())
                .meterCost(siteSubTask.getMeterCost())
                .squareMeterCost(siteSubTask.getSquareMeterCost())
                .cubicMeterCost(siteSubTask.getCubicMeterCost())
                .build();
    }

    public SiteSubTask toEntity(SiteSubTaskDto siteSubTaskDto) {
        return SiteSubTask.builder()
                .id(siteSubTaskDto.getId())
                .siteTask(siteSubTaskDto.getSiteTask())
                .subTaskName(siteSubTaskDto.getSubTaskName())
                .subTaskDescription(siteSubTaskDto.getSubTaskDescription())
                .meterCost(siteSubTaskDto.getMeterCost())
                .squareMeterCost(siteSubTaskDto.getSquareMeterCost())
                .cubicMeterCost(siteSubTaskDto.getCubicMeterCost())
                .build();
    }
}
