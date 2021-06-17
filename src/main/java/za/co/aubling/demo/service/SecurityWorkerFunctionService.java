package za.co.aubling.demo.service;

import org.springframework.stereotype.Service;
import za.co.aubling.demo.dao.SecurityWorkerFunctionRepository;
import za.co.aubling.demo.domain.SecurityWorkerFunction;
import za.co.aubling.demo.dto.SecurityWorkerFunctionDto;
import za.co.aubling.demo.id.SecurityWorkerFunctionId;
import za.co.aubling.demo.mapper.SecurityWorkerFunctionMapper;

import javax.persistence.IdClass;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@IdClass(SecurityWorkerFunctionId.class)
@Service
public class SecurityWorkerFunctionService {

    private final SecurityWorkerFunctionMapper securityWorkerFunctionMapper;

    private final SecurityWorkerFunctionRepository securityWorkerFunctionRepository;

    public SecurityWorkerFunctionService(SecurityWorkerFunctionRepository securityWorkerFunctionRepository, SecurityWorkerFunctionMapper securityWorkerFunctionMapper) {
        this.securityWorkerFunctionRepository = securityWorkerFunctionRepository;
        this.securityWorkerFunctionMapper = securityWorkerFunctionMapper;
    }

    @Transactional
    public SecurityWorkerFunction addWorkerFunction(SecurityWorkerFunctionDto securityWorkerFunctionDto){
        SecurityWorkerFunction securityWorkerFunction = securityWorkerFunctionMapper.toEntity(securityWorkerFunctionDto);
        return securityWorkerFunctionRepository.save(securityWorkerFunction);
    }

    public List<SecurityWorkerFunction> getWorkerFunctions() {
        return securityWorkerFunctionRepository.findAll();
    }

    public SecurityWorkerFunction getWorkerFunction(String workerId, String functionId) {
        Optional<SecurityWorkerFunction> securityWorkerFunction = securityWorkerFunctionRepository.findById(new SecurityWorkerFunctionId(workerId,functionId));
        if (!securityWorkerFunction.isPresent()) {
            throw new RuntimeException(String.format("Project with id %s does not exist", workerId + " " + functionId ));
        }
        return securityWorkerFunction.get();
    }
}
