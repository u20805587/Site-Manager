package za.co.aubling.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.aubling.demo.domain.SecurityRole;
import za.co.aubling.demo.dto.SecurityRoleDto;
import za.co.aubling.demo.mapper.SecurityRoleMapper;
import za.co.aubling.demo.service.AuditLogService;
import za.co.aubling.demo.service.SecurityRoleService;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/role")
public class SecurityRoleController {

    private final SecurityRoleMapper securityRoleMapper;

    private final SecurityRoleService securityRoleService;

    private final AuditLogService auditLogService;


    public SecurityRoleController(SecurityRoleService securityRoleService,
                                  SecurityRoleMapper securityRoleMapper,
                                  AuditLogService auditLogService) {
        this.securityRoleMapper = securityRoleMapper;
        this.securityRoleService = securityRoleService;
        this.auditLogService = auditLogService;
    }

    @PostMapping
    public ResponseEntity<SecurityRole> addRole(@RequestBody SecurityRoleDto securityRoleDto) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        log.debug("Aubs Starting Here: {}", securityRoleDto);
            SecurityRole securityRole = securityRoleService.addRole(securityRoleDto);
        log.debug("Aubs Failed here: {}", securityRoleDto);
            auditLogService.AuditRole(securityRole);
            return ResponseEntity.ok(securityRole);
    }

    @GetMapping
    public ResponseEntity<List<SecurityRoleDto>> getRoles() {
        List<SecurityRole> securityRoles = securityRoleService.getRoles();
        return ResponseEntity.ok(securityRoles.stream()
                .map(securityRoleMapper::toDto)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{roleId}")
    public ResponseEntity<SecurityRoleDto> getProject(@PathVariable String roleId) {
        SecurityRole role = securityRoleService.getRole(roleId);
        return ResponseEntity.ok(securityRoleMapper.toDto(role));
    }

}
