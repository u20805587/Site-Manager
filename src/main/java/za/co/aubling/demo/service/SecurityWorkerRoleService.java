package za.co.aubling.demo.service;

import org.springframework.stereotype.Service;
import za.co.aubling.demo.dao.SecurityWorkerRoleRepository;
import za.co.aubling.demo.domain.SecurityWorkerRole;
import za.co.aubling.demo.dto.SecurityWorkerRoleDto;
import za.co.aubling.demo.id.SecurityWorkerRoleId;
import za.co.aubling.demo.mapper.SecurityWorkerRoleMapper;

import javax.persistence.IdClass;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@IdClass(SecurityWorkerRoleId.class)
@Service
public class SecurityWorkerRoleService {

    private final SecurityWorkerRoleMapper securityWorkerRoleMapper;

    private final SecurityWorkerRoleRepository securityWorkerRoleRepository;

    public SecurityWorkerRoleService(SecurityWorkerRoleRepository securityWorkerRoleRepository, SecurityWorkerRoleMapper securityWorkerRoleMapper) {
        this.securityWorkerRoleRepository = securityWorkerRoleRepository;
        this.securityWorkerRoleMapper = securityWorkerRoleMapper;
    }

    @Transactional
    public SecurityWorkerRole addWorkerRole(SecurityWorkerRoleDto securityWorkerRoleDto){
        SecurityWorkerRole securityWorkerRole = securityWorkerRoleMapper.toEntity(securityWorkerRoleDto);
        return securityWorkerRoleRepository.save(securityWorkerRole);
    }

    public List<SecurityWorkerRole> getWorkerRoles() {
        return securityWorkerRoleRepository.findAll();
    }

    public SecurityWorkerRole getWorkerRole(String workerId, String roleId) {
        Optional<SecurityWorkerRole> securityWorkerRole = securityWorkerRoleRepository.findById(new SecurityWorkerRoleId(workerId,roleId));
        if (!securityWorkerRole.isPresent()) {
            throw new RuntimeException(String.format("Project with id %s does not exist", workerId + " " + roleId ));
        }
        return securityWorkerRole.get();
    }
}
