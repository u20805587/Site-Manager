package za.co.aubling.demo.mapper;

import org.springframework.stereotype.Component;
import za.co.aubling.demo.domain.SecurityRoleFunction;
import za.co.aubling.demo.dto.SecurityRoleFunctionDto;

@Component
public class SecurityRoleFunctionMapper {
    public SecurityRoleFunctionDto toDto(SecurityRoleFunction securityRoleFunction) {
        return SecurityRoleFunctionDto.builder()
                .roleId(securityRoleFunction.getRoleId())
                .functionId(securityRoleFunction.getFunctionId())
                .insert(securityRoleFunction.getInsert())
                .modify(securityRoleFunction.getModify())
                .delete(securityRoleFunction.getDelete())
                .view(securityRoleFunction.getView())
                .build();
    }

    public SecurityRoleFunction toEntity(SecurityRoleFunctionDto securityRoleFunctionDto) {
        return SecurityRoleFunction.builder()
                .roleId(securityRoleFunctionDto.getRoleId())
                .functionId(securityRoleFunctionDto.getFunctionId())
                .insert(securityRoleFunctionDto.getInsert())
                .modify(securityRoleFunctionDto.getModify())
                .delete(securityRoleFunctionDto.getDelete())
                .view(securityRoleFunctionDto.getView())
                .build();
    }
}
