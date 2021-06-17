package za.co.aubling.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.aubling.demo.domain.SecurityFunction;
import za.co.aubling.demo.dto.SecurityFunctionDto;
import za.co.aubling.demo.mapper.SecurityFunctionMapper;
import za.co.aubling.demo.service.AuditLogService;
import za.co.aubling.demo.service.SecurityFunctionService;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/function")
public class SecurityFunctionController {

    private final SecurityFunctionMapper securityFunctionMapper;

    private final SecurityFunctionService securityFunctionService;

    private final AuditLogService auditLogService;


    public SecurityFunctionController(SecurityFunctionService securityFunctionService,
                                      SecurityFunctionMapper securityFunctionMapper,
                                      AuditLogService auditLogService) {
        this.securityFunctionMapper = securityFunctionMapper;
        this.securityFunctionService = securityFunctionService;
        this.auditLogService = auditLogService;
    }

    @PostMapping
    public ResponseEntity<SecurityFunction> addFunction(@RequestBody SecurityFunctionDto securityFunctionDto) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        log.debug("Site project: {}", securityFunctionDto);
            SecurityFunction securityFunction = securityFunctionService.addFunction(securityFunctionDto);
            auditLogService.AuditFunction(securityFunction);
            return ResponseEntity.ok(securityFunction);
    }

    @GetMapping
    public ResponseEntity<List<SecurityFunctionDto>> getFunctions() {
        List<SecurityFunction> securityFunctions = securityFunctionService.getFunctions();
        return ResponseEntity.ok(securityFunctions.stream()
                .map(securityFunctionMapper::toDto)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{functionId}")
    public ResponseEntity<SecurityFunctionDto> getProject(@PathVariable String functionId) {
        SecurityFunction function = securityFunctionService.getFunction(functionId);
        return ResponseEntity.ok(securityFunctionMapper.toDto(function));
    }

}
