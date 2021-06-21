package za.co.aubling.demo.mapper;

import org.springframework.stereotype.Component;
import za.co.aubling.demo.domain.SiteProjectWorkerLog;
import za.co.aubling.demo.dto.SiteProjectWorkerLogDto;

@Component
public class SiteProjectWorkerLogMapper {
    public SiteProjectWorkerLogDto toDto(SiteProjectWorkerLog siteProjectWorkerLog) {
        return SiteProjectWorkerLogDto.builder()
                .workerId(siteProjectWorkerLog.getWorkerId())
                .projectId(siteProjectWorkerLog.getProjectId())
                .workDate(siteProjectWorkerLog.getWorkDate())
                .hours(siteProjectWorkerLog.getHours())
                .build();
    }

    public SiteProjectWorkerLog toEntity(SiteProjectWorkerLogDto siteProjectWorkerLogDto) {
        return SiteProjectWorkerLog.builder()
                .workerId(siteProjectWorkerLogDto.getWorkerId())
                .projectId(siteProjectWorkerLogDto.getProjectId())
                .workDate(siteProjectWorkerLogDto.getWorkDate())
                .hours(siteProjectWorkerLogDto.getHours())
                .build();
    }
}
