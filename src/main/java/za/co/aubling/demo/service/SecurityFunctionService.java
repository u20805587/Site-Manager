package za.co.aubling.demo.service;

import org.springframework.stereotype.Service;
import za.co.aubling.demo.dao.SecurityFunctionRepository;
import za.co.aubling.demo.domain.SecurityFunction;
import za.co.aubling.demo.dto.SecurityFunctionDto;
import za.co.aubling.demo.mapper.SecurityFunctionMapper;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SecurityFunctionService {

    private final SecurityFunctionMapper securityFunctionMapper;

    private final SecurityFunctionRepository securityFunctionRepository;

    public SecurityFunctionService(SecurityFunctionRepository securityFunctionRepository, SecurityFunctionMapper securityFunctionMapper) {
        this.securityFunctionRepository = securityFunctionRepository;
        this.securityFunctionMapper = securityFunctionMapper;
    }

    @Transactional
    public SecurityFunction addFunction(SecurityFunctionDto securityFunctionDto){
        SecurityFunction securityFunction = securityFunctionMapper.toEntity(securityFunctionDto);
        return securityFunctionRepository.save(securityFunction);
    }

    public List<SecurityFunction> getFunctions() {
        return securityFunctionRepository.findAll();
    }

    public SecurityFunction getFunction(String functionId) {
        Optional<SecurityFunction> securityFunction = securityFunctionRepository.findById(functionId);
        if (!securityFunction.isPresent()) {
            throw new RuntimeException(String.format("Function with id %s does not exist", functionId));
        }
        return securityFunction.get();
    }
}
