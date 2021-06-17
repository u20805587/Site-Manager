package za.co.aubling.demo.service;

import org.springframework.stereotype.Service;
import za.co.aubling.demo.dao.SecurityRoleRepository;
import za.co.aubling.demo.domain.SecurityRole;
import za.co.aubling.demo.dto.SecurityRoleDto;
import za.co.aubling.demo.mapper.SecurityRoleMapper;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SecurityRoleService {

    private final SecurityRoleMapper securityRoleMapper;

    private final SecurityRoleRepository securityRoleRepository;

    public SecurityRoleService(SecurityRoleRepository securityRoleRepository, SecurityRoleMapper securityRoleMapper) {
        this.securityRoleRepository = securityRoleRepository;
        this.securityRoleMapper = securityRoleMapper;
    }

    @Transactional
    public SecurityRole addRole(SecurityRoleDto securityRoleDto){
        SecurityRole securityRole = securityRoleMapper.toEntity(securityRoleDto);
        return securityRoleRepository.save(securityRole);
    }

    public List<SecurityRole> getRoles() {
        return securityRoleRepository.findAll();
    }

    public SecurityRole getRole(String roleId) {
        Optional<SecurityRole> securityRole = securityRoleRepository.findById(roleId);
        if (!securityRole.isPresent()) {
            throw new RuntimeException(String.format("Project with id %s does not exist", roleId));
        }
        return securityRole.get();
    }
}
