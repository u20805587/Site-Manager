package za.co.aubling.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import za.co.aubling.demo.domain.SecurityRoleFunction;
import za.co.aubling.demo.dto.SecurityRoleFunctionDto;
import za.co.aubling.demo.mapper.SecurityRoleFunctionMapper;
import za.co.aubling.demo.service.AuditLogService;
import za.co.aubling.demo.service.SecurityRoleFunctionService;
import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@Controller
@RequestMapping("/api/rolefunction")
public class SecurityRoleFunctionController {

    private final SecurityRoleFunctionMapper securityRoleFunctionMapper;

    private final SecurityRoleFunctionService securityRoleFunctionService;

    private final AuditLogService auditLogService;


    public SecurityRoleFunctionController(SecurityRoleFunctionService securityRoleFunctionService,
                                          SecurityRoleFunctionMapper securityRoleFunctionMapper,
                                          AuditLogService auditLogService) {
        this.securityRoleFunctionMapper = securityRoleFunctionMapper;
        this.securityRoleFunctionService = securityRoleFunctionService;
        this.auditLogService = auditLogService;
    }

    @PostMapping
    public ResponseEntity<SecurityRoleFunction> addRoleFunction(@RequestBody SecurityRoleFunctionDto securityRoleFunctionDto) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
            SecurityRoleFunction securityRoleFunction = securityRoleFunctionService.addRoleFunction(securityRoleFunctionDto);
            auditLogService.AuditRoleFunction(securityRoleFunction);
            return ResponseEntity.ok(securityRoleFunction);
    }

    @GetMapping
    public ResponseEntity<List<SecurityRoleFunctionDto>> getRoleFunctions() {
        List<SecurityRoleFunction> securityRoleFunctions = securityRoleFunctionService.getRoleFunctions();
        return ResponseEntity.ok(securityRoleFunctions.stream()
                .map(securityRoleFunctionMapper::toDto)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{roleId}/{functionId}")
    public ResponseEntity<SecurityRoleFunctionDto> getRoleFunction(@PathVariable String roleId,@PathVariable String functionId) {
        SecurityRoleFunction RoleFunction = securityRoleFunctionService.getRoleFunction(roleId,functionId);
        return ResponseEntity.ok(securityRoleFunctionMapper.toDto(RoleFunction));
    }

}
