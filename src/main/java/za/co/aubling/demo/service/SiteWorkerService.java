package za.co.aubling.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import za.co.aubling.demo.dao.SiteWorkerRepository;
import za.co.aubling.demo.domain.SecurityRole;
import za.co.aubling.demo.domain.SiteProject;
import za.co.aubling.demo.domain.SiteWorker;
import za.co.aubling.demo.dto.SiteWorkerDto;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SiteWorkerService {

    private final SiteWorkerRepository siteWorkerRepository;

    public SiteWorkerService(SiteWorkerRepository siteWorkerRepository) {
        this.siteWorkerRepository = siteWorkerRepository;
    }

    @Transactional
    public SiteWorker addSiteWorker(SiteWorkerDto siteWorkerDto) {
        SiteWorker siteWorker = SiteWorker.builder()
                .workerId(siteWorkerDto.getWorkerId())
                .middleName(siteWorkerDto.getMiddleName())
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
                .username(siteWorkerDto.getUsername())
                .password(siteWorkerDto.getPassword())
                .siteWorkerCategory(siteWorkerDto.getSiteWorkerCategory())
                .build();
        return siteWorkerRepository.save(siteWorker);
    }

    public List<SiteWorker> getWorkers() {
        return siteWorkerRepository.findAll();
    }

    public SiteWorker getWorker(Long workerId) {
        Optional<SiteWorker> siteWorker = siteWorkerRepository.findById(workerId);
        if (!siteWorker.isPresent()) {
            throw new RuntimeException(String.format("Worker with id %s does not exist", workerId));
        }
        return siteWorker.get();
    }

    public SiteWorker findByUsername(String username) {
        Class<SiteWorker> entityClass = null;
        EntityManager entityManager = null;
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<SiteWorker> criteriaQuery = criteriaBuilder.createQuery(entityClass);
        Root<SiteWorker> root = criteriaQuery.from(entityClass);
        criteriaQuery.select(root);

        ParameterExpression<String> params = criteriaBuilder.parameter(String.class);
        criteriaQuery.where(criteriaBuilder.equal(root.get("username"), params));

        TypedQuery<SiteWorker> query = entityManager.createQuery(criteriaQuery);
        query.setParameter(params, username);

        List<SiteWorker> queryResult = query.getResultList();

        SiteWorker worker = null;

        if (!CollectionUtils.isEmpty(queryResult)) {
            worker = queryResult.get(0);
        }

        return worker;
    }
}
