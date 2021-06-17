package za.co.aubling.demo.mapper;

import org.springframework.stereotype.Component;
import za.co.aubling.demo.domain.SecurityFunction;
import za.co.aubling.demo.dto.SecurityFunctionDto;

@Component
public class SecurityFunctionMapper {
    public SecurityFunctionDto toDto(SecurityFunction securityFunction) {
        return SecurityFunctionDto.builder()
                .functionId(securityFunction.getFunctionID())
                .description(securityFunction.getDescription())
                .build();
    }

    public SecurityFunction toEntity(SecurityFunctionDto securityFunctionDto) {
        return SecurityFunction.builder()
                .functionID(securityFunctionDto.getFunctionId())
                .description(securityFunctionDto.getDescription())
                .build();
    }
}
