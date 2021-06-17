package za.co.aubling.demo.service;

import org.springframework.stereotype.Service;
import za.co.aubling.demo.dao.SecurityRoleFunctionRepository;
import za.co.aubling.demo.domain.SecurityRoleFunction;
import za.co.aubling.demo.dto.SecurityRoleFunctionDto;
import za.co.aubling.demo.id.SecurityRoleFunctionId;
import za.co.aubling.demo.mapper.SecurityRoleFunctionMapper;

import javax.persistence.IdClass;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@IdClass(SecurityRoleFunctionId.class)
@Service
public class SecurityRoleFunctionService {

    private final SecurityRoleFunctionMapper securityRoleFunctionMapper;

    private final SecurityRoleFunctionRepository securityRoleFunctionRepository;

    public SecurityRoleFunctionService(SecurityRoleFunctionRepository securityRoleFunctionRepository, SecurityRoleFunctionMapper securityRoleFunctionMapper) {
        this.securityRoleFunctionRepository = securityRoleFunctionRepository;
        this.securityRoleFunctionMapper = securityRoleFunctionMapper;
    }

    @Transactional
    public SecurityRoleFunction addRoleFunction(SecurityRoleFunctionDto securityRoleFunctionDto){
        SecurityRoleFunction securityRoleFunction = securityRoleFunctionMapper.toEntity(securityRoleFunctionDto);
        return securityRoleFunctionRepository.save(securityRoleFunction);
    }

    public List<SecurityRoleFunction> getRoleFunctions() {
        return securityRoleFunctionRepository.findAll();
    }

    public SecurityRoleFunction getRoleFunction(String roleId, String functionId) {
        Optional<SecurityRoleFunction> securityRoleFunction = securityRoleFunctionRepository.findById(new SecurityRoleFunctionId(roleId,functionId));
        if (!securityRoleFunction.isPresent()) {
            throw new RuntimeException(String.format("Role Function with id %s does not exist", roleId + " " + functionId ));
        }
        return securityRoleFunction.get();
    }
}
