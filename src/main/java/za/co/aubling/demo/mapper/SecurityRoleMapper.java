package za.co.aubling.demo.mapper;

import org.springframework.stereotype.Component;
import za.co.aubling.demo.domain.SecurityRole;
import za.co.aubling.demo.dto.SecurityRoleDto;

@Component
public class SecurityRoleMapper {
    public SecurityRoleDto toDto(SecurityRole securityRole) {
        return SecurityRoleDto.builder()
                .roleId(securityRole.getRoleId())
                .description(securityRole.getRoleId())
                .build();
    }

    public SecurityRole toEntity(SecurityRoleDto securityRoleDto) {
        return SecurityRole.builder()
                .roleId(securityRoleDto.getRoleId())
                .description(securityRoleDto.getDescription())
                .build();
    }
}
