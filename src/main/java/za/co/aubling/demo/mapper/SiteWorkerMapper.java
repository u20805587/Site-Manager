package za.co.aubling.demo.mapper;

import org.springframework.stereotype.Component;
import za.co.aubling.demo.domain.SiteWorker;
import za.co.aubling.demo.dto.SiteWorkerDto;

@Component
public class SiteWorkerMapper {
    public SiteWorkerDto toDto(SiteWorker siteWorker) {
        return SiteWorkerDto.builder()
                .name(siteWorker.getName())
                .surname(siteWorker.getSurname())
                .idNumber(siteWorker.getIdNumber())
                .gender(siteWorker.getGender())
                .addressLine1(siteWorker.getAddressLine1())
                .addressLine2(siteWorker.getAddressLine2())
                .addressLine3(siteWorker.getAddressLine3())
                .postalCode(siteWorker.getPostalCode())
                .build();
    }

    public SiteWorker toEntity(SiteWorkerDto siteWorkerDto) {
        return SiteWorker.builder()
                .name(siteWorkerDto.getName())
                .surname(siteWorkerDto.getSurname())
                .gender(siteWorkerDto.getGender())
                .idNumber(siteWorkerDto.getIdNumber())
                .addressLine1(siteWorkerDto.getAddressLine1())
                .addressLine2(siteWorkerDto.getAddressLine2())
                .addressLine3(siteWorkerDto.getAddressLine3())
                .contactNumber(siteWorkerDto.getContactNumber())
                .hourlyRate(siteWorkerDto.getHourlyRate())
                .postalCode(siteWorkerDto.getPostalCode())
                .build();
    }
}
