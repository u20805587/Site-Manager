package za.co.aubling.demo.mapper;

import org.springframework.stereotype.Component;
import za.co.aubling.demo.domain.AuditLogField;
import za.co.aubling.demo.dto.AuditLogFieldDto;

@Component
public class AuditLogFieldMapper {
    public AuditLogFieldDto toDto(AuditLogField auditLogField) {
        return AuditLogFieldDto.builder()
                .keyId(auditLogField.getKeyId())
                .modificationNo(auditLogField.getModificationNo())
                .fieldName(auditLogField.getFieldName())
                .oldValue(auditLogField.getOldValue())
                .newValue(auditLogField.getNewValue())
                .build();
    }

    public AuditLogField toEntity(AuditLogFieldDto auditLogFieldDto) {
        return AuditLogField.builder()
                .keyId(auditLogFieldDto.getKeyId())
                .modificationNo(auditLogFieldDto.getModificationNo())
                .fieldName(auditLogFieldDto.getFieldName())
                .oldValue(auditLogFieldDto.getOldValue())
                .newValue(auditLogFieldDto.getNewValue())
                .build();
    }
}
