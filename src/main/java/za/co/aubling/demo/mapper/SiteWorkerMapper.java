package za.co.aubling.demo.mapper;

import org.springframework.stereotype.Component;
import za.co.aubling.demo.domain.SiteWorker;
import za.co.aubling.demo.dto.SiteWorkerDto;

@Component
public class SiteWorkerMapper {
    public SiteWorkerDto toDto(SiteWorker siteWorker) {
        return SiteWorkerDto.builder()
                .workerId(siteWorker.getWorkerId())
                .name(siteWorker.getName())
                .middleName(siteWorker.getMiddleName())
                .surname(siteWorker.getSurname())
                .gender(siteWorker.getGender())
                .idNumber(siteWorker.getIdNumber())
                .addressLine1(siteWorker.getAddressLine1())
                .addressLine2(siteWorker.getAddressLine2())
                .addressLine3(siteWorker.getAddressLine3())
                .contactNumber(siteWorker.getContactNumber())
                .hourlyRate(siteWorker.getHourlyRate())
                .postalCode(siteWorker.getPostalCode())
                .nationality(siteWorker.getNationality())
                .siteWorkerCategory(siteWorker.getSiteWorkerCategory())
                .stateCode(siteWorker.getStateCode())
                .username(siteWorker.getUsername())
                .password(siteWorker.getPassword())
                .userStatus(siteWorker.getUserStatus())
                .build();
    }

    public SiteWorker toEntity(SiteWorkerDto siteWorkerDto) {
        return SiteWorker.builder()
                .workerId(siteWorkerDto.getWorkerId())
                .name(siteWorkerDto.getName())
                .middleName(siteWorkerDto.getMiddleName())
                .surname(siteWorkerDto.getSurname())
                .gender(siteWorkerDto.getGender())
                .idNumber(siteWorkerDto.getIdNumber())
                .addressLine1(siteWorkerDto.getAddressLine1())
                .addressLine2(siteWorkerDto.getAddressLine2())
                .addressLine3(siteWorkerDto.getAddressLine3())
                .contactNumber(siteWorkerDto.getContactNumber())
                .hourlyRate(siteWorkerDto.getHourlyRate())
                .postalCode(siteWorkerDto.getPostalCode())
                .nationality(siteWorkerDto.getNationality())
                .siteWorkerCategory(siteWorkerDto.getSiteWorkerCategory())
                .stateCode(siteWorkerDto.getStateCode())
                .username(siteWorkerDto.getUsername())
                .password(siteWorkerDto.getPassword())
                .userStatus(siteWorkerDto.getUserStatus())
                .build();
    }
}
