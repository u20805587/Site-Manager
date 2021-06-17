package za.co.aubling.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import za.co.aubling.demo.domain.SecurityWorkerRole;
import za.co.aubling.demo.dto.SecurityWorkerRoleDto;
import za.co.aubling.demo.mapper.SecurityWorkerRoleMapper;
import za.co.aubling.demo.service.AuditLogService;
import za.co.aubling.demo.service.SecurityWorkerRoleService;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@Controller
@RequestMapping("/api/workerrole")
public class SecurityWorkerRoleController {

    private final SecurityWorkerRoleMapper securityWorkerRoleMapper;

    private final SecurityWorkerRoleService securityWorkerRoleService;

    private final AuditLogService auditLogService;


    public SecurityWorkerRoleController(SecurityWorkerRoleService securityWorkerRoleService,
                                        SecurityWorkerRoleMapper securityWorkerRoleMapper,
                                        AuditLogService auditLogService) {
        this.securityWorkerRoleMapper = securityWorkerRoleMapper;
        this.securityWorkerRoleService = securityWorkerRoleService;
        this.auditLogService = auditLogService;
    }

    @PostMapping
    public ResponseEntity<SecurityWorkerRole> addWorkerRole(@RequestBody SecurityWorkerRoleDto securityWorkerRoleDto) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        log.debug("Site project: {}", securityWorkerRoleDto);
            SecurityWorkerRole securityWorkerRole = securityWorkerRoleService.addWorkerRole(securityWorkerRoleDto);
            auditLogService.AuditWorkerRole(securityWorkerRole);
            return ResponseEntity.ok(securityWorkerRole);
    }

    @GetMapping
    public ResponseEntity<List<SecurityWorkerRoleDto>> getWorkerRoles() {
        List<SecurityWorkerRole> securityWorkerRoles = securityWorkerRoleService.getWorkerRoles();
        return ResponseEntity.ok(securityWorkerRoles.stream()
                .map(securityWorkerRoleMapper::toDto)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{roleId},{functionId}")
    public ResponseEntity<SecurityWorkerRoleDto> getProject(@PathVariable String roleId, String functionId) {
        SecurityWorkerRole WorkerRole = securityWorkerRoleService.getWorkerRole(roleId,functionId);
        return ResponseEntity.ok(securityWorkerRoleMapper.toDto(WorkerRole));
    }

}
