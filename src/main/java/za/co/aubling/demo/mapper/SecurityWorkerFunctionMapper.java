package za.co.aubling.demo.mapper;

import org.springframework.stereotype.Component;
import za.co.aubling.demo.domain.SecurityWorkerFunction;
import za.co.aubling.demo.dto.SecurityWorkerFunctionDto;

@Component
public class SecurityWorkerFunctionMapper {
    public SecurityWorkerFunctionDto toDto(SecurityWorkerFunction securityWorkerFunction) {
        return SecurityWorkerFunctionDto.builder()
                .workerId(securityWorkerFunction.getWorkerId())
                .functionId(securityWorkerFunction.getFunctionId())
                .insert(securityWorkerFunction.getInsert())
                .modify(securityWorkerFunction.getModify())
                .delete(securityWorkerFunction.getDelete())
                .build();
    }

    public SecurityWorkerFunction toEntity(SecurityWorkerFunctionDto securityWorkerFunctionDto) {
        return SecurityWorkerFunction.builder()
                .workerId(securityWorkerFunctionDto.getWorkerId())
                .functionId(securityWorkerFunctionDto.getFunctionId())
                .insert(securityWorkerFunctionDto.getInsert())
                .modify(securityWorkerFunctionDto.getModify())
                .delete(securityWorkerFunctionDto.getDelete())
                .build();
    }
}
