package za.co.aubling.demo.mapper;

import org.springframework.stereotype.Component;
import za.co.aubling.demo.domain.SecurityWorkerRole;
import za.co.aubling.demo.dto.SecurityWorkerRoleDto;

@Component
public class SecurityWorkerRoleMapper {
    public SecurityWorkerRoleDto toDto(SecurityWorkerRole securityWorkerRole) {
        return SecurityWorkerRoleDto.builder()
                .roleId(securityWorkerRole.getRoleId())
                .workerId(securityWorkerRole.getWorkerId())
                .build();
    }

    public SecurityWorkerRole toEntity(SecurityWorkerRoleDto securityWorkerRoleDto) {
        return SecurityWorkerRole.builder()
                .roleId(securityWorkerRoleDto.getRoleId())
                .workerId(securityWorkerRoleDto.getWorkerId())
                .build();
    }
}
