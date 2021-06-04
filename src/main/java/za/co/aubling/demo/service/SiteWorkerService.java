package za.co.aubling.demo.service;

import org.springframework.stereotype.Service;
import za.co.aubling.demo.dao.SiteWorkerRepository;
import za.co.aubling.demo.domain.SiteProject;
import za.co.aubling.demo.domain.SiteWorker;
import za.co.aubling.demo.dto.SiteWorkerDto;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SiteWorkerService {

    private final SiteWorkerRepository siteWorkerRepository;

    public SiteWorkerService(SiteWorkerRepository siteWorkerRepository) {
        this.siteWorkerRepository = siteWorkerRepository;
    }

    @Transactional
    public SiteWorker addSiteWorker(SiteWorkerDto siteWorkerDto) {
        SiteWorker siteWorker = SiteWorker.builder()
                .name(siteWorkerDto.getName())
                .surname(siteWorkerDto.getSurname())
                .addressLine1(siteWorkerDto.getAddressLine1())
                .addressLine2(siteWorkerDto.getAddressLine2())
                .addressLine3(siteWorkerDto.getAddressLine3())
                .gender(siteWorkerDto.getGender())
                .nationality(siteWorkerDto.getNationality())
                .birthDate(siteWorkerDto.getBirthDate())
                .postalCode(siteWorkerDto.getPostalCode())
                .contactNumber(siteWorkerDto.getContactNumber())
                .idNumber(siteWorkerDto.getIdNumber())
                .stateCode(siteWorkerDto.getStateCode())
                .hourlyRate(siteWorkerDto.getHourlyRate())
                .build();
        return siteWorkerRepository.save(siteWorker);
    }

    public List<SiteWorker> getWorkers() {
        return siteWorkerRepository.findAll();
    }
}
