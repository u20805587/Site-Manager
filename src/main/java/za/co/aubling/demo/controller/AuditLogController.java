package za.co.aubling.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.aubling.demo.domain.AuditLog;
import za.co.aubling.demo.dto.AuditLogDto;
import za.co.aubling.demo.mapper.AuditLogMapper;
import za.co.aubling.demo.service.AuditLogService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/audit")
public class AuditLogController {

    private final AuditLogService auditLogService;
    private final AuditLogMapper auditLogMapper;

    public AuditLogController(AuditLogService auditLogService,
                              AuditLogMapper auditLogMapper) {
        this.auditLogService = auditLogService;
        this.auditLogMapper = auditLogMapper;
    }

    @PostMapping
    public ResponseEntity<AuditLog> addAuditLog(@RequestBody AuditLogDto auditLogDto) {
        AuditLog auditLog = auditLogService.addAuditLog(auditLogDto);
        return ResponseEntity.ok(auditLog);
    }

    @GetMapping
    public ResponseEntity<List<AuditLogDto>> getAuditLog() {
        List<AuditLog> auditLog = auditLogService.getAuditLog();
        return ResponseEntity.ok(auditLog.stream()
                .map(auditLogMapper::toDto)
                .collect(Collectors.toList()));
    }

}