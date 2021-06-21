package za.co.aubling.demo.mapper;

import org.springframework.stereotype.Component;
import za.co.aubling.demo.domain.SiteProjectWorker;
import za.co.aubling.demo.dto.SiteProjectWorkerDto;

@Component
public class SiteProjectWorkerMapper {
    public SiteProjectWorkerDto toDto(SiteProjectWorker siteProjectWorker) {
        return SiteProjectWorkerDto.builder()
                .workerId(siteProjectWorker.getWorkerId())
                .projectId(siteProjectWorker.getProjectId())
                .hourlyRate(siteProjectWorker.getHourlyRate())
                .build();
    }

    public SiteProjectWorker toEntity(SiteProjectWorkerDto siteProjectWorkerDto) {
        return SiteProjectWorker.builder()
                .workerId(siteProjectWorkerDto.getWorkerId())
                .projectId(siteProjectWorkerDto.getProjectId())
                .hourlyRate(siteProjectWorkerDto.getHourlyRate())
                .build();
    }
}
