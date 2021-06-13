package za.co.aubling.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.aubling.demo.domain.AuditLogField;
import za.co.aubling.demo.dto.AuditLogFieldDto;
import za.co.aubling.demo.mapper.AuditLogFieldMapper;
import za.co.aubling.demo.service.AuditLogFieldService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auditfields")
public class AuditLogFieldController {

    private final AuditLogFieldService auditLogFieldService;
    private final AuditLogFieldMapper auditLogFieldMapper;

    public AuditLogFieldController(AuditLogFieldService auditLogFieldService, AuditLogFieldMapper auditLogFieldMapper) {
        this.auditLogFieldService = auditLogFieldService;
        this.auditLogFieldMapper = auditLogFieldMapper;
    }

    @PostMapping
    public ResponseEntity<AuditLogField> addAuditLogField(@RequestBody AuditLogFieldDto auditLogFieldDto) {
        AuditLogField auditLogField = auditLogFieldService.addAuditLogField(auditLogFieldDto);
        return ResponseEntity.ok(auditLogField);
    }

    @GetMapping
    public ResponseEntity<List<AuditLogFieldDto>> getAuditLogField() {
        List<AuditLogField> auditLogField = auditLogFieldService.getAuditLogField();
        return ResponseEntity.ok(auditLogField.stream()
                .map(auditLogFieldMapper::toDto)
                .collect(Collectors.toList()));
    }

}