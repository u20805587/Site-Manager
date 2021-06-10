package za.co.aubling.demo.service;

import org.springframework.stereotype.Service;
import za.co.aubling.demo.dao.AuditLogRepository;
import za.co.aubling.demo.domain.AuditLog;
import za.co.aubling.demo.dto.AuditLogDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AuditLogService {

    private final AuditLogRepository AuditLogRepository;

    public AuditLogService(AuditLogRepository AuditLogRepository) {
        this.AuditLogRepository = AuditLogRepository;
    }

    @Transactional
    public AuditLog addAuditLog(AuditLogDto auditLogDto) {
        AuditLog auditLog = AuditLog.builder()
                .keyId(auditLogDto.getKeyId())
                .action(auditLogDto.getAction())
                .modificationNo(auditLogDto.getModificationNo())
                .keyColumns(auditLogDto.getKeyColumns())
                .modifiedBy(auditLogDto.getModifiedBy())
                .modificationTimestamp(auditLogDto.getModificationTimestamp())
                .tableName(auditLogDto.getTableName())
                .build();
        return AuditLogRepository.save(auditLog);
    }

    public List<AuditLog> getAuditLog() {
        return AuditLogRepository.findAll();
    }

    public Optional<AuditLog> getAuditLog(String keyId) {
        return AuditLogRepository.findById(keyId);
    }

}
