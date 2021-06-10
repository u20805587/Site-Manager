package za.co.aubling.demo.mapper;

import org.springframework.stereotype.Component;
import za.co.aubling.demo.domain.AuditLog;
import za.co.aubling.demo.dto.AuditLogDto;

@Component
public class AuditLogMapper {
    public AuditLogDto toDto(AuditLog auditLog) {
        return AuditLogDto.builder()
                .keyId(auditLog.getKeyId())
                .action(auditLog.getAction())
                .modificationNo(auditLog.getModificationNo())
                .keyColumns(auditLog.getKeyColumns())
                .modifiedBy(auditLog.getModifiedBy())
                .modificationTimestamp(auditLog.getModificationTimestamp())
                .tableName(auditLog.getTableName())
                .build();
    }

    public AuditLog toEntity(AuditLogDto auditLogDto) {
        return AuditLog.builder()
                .keyId(auditLogDto.getKeyId())
                .action(auditLogDto.getAction())
                .modificationNo(auditLogDto.getModificationNo())
                .keyColumns(auditLogDto.getKeyColumns())
                .modifiedBy(auditLogDto.getModifiedBy())
                .modificationTimestamp(auditLogDto.getModificationTimestamp())
                .tableName(auditLogDto.getTableName())
                .build();
    }
}
