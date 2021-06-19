package za.co.aubling.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import za.co.aubling.demo.domain.SecurityWorkerFunction;
import za.co.aubling.demo.dto.SecurityWorkerFunctionDto;
import za.co.aubling.demo.mapper.SecurityWorkerFunctionMapper;
import za.co.aubling.demo.service.AuditLogService;
import za.co.aubling.demo.service.SecurityWorkerFunctionService;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@Controller
@RequestMapping("/api/workerfunction")
public class SecurityWorkerFunctionController {

    private final SecurityWorkerFunctionMapper securityWorkerFunctionMapper;

    private final SecurityWorkerFunctionService securityWorkerFunctionService;

    private final AuditLogService auditLogService;


    public SecurityWorkerFunctionController(SecurityWorkerFunctionService securityWorkerFunctionService,
                                            SecurityWorkerFunctionMapper securityWorkerFunctionMapper,
                                            AuditLogService auditLogService) {
        this.securityWorkerFunctionMapper = securityWorkerFunctionMapper;
        this.securityWorkerFunctionService = securityWorkerFunctionService;
        this.auditLogService = auditLogService;
    }

    @PostMapping
    public ResponseEntity<SecurityWorkerFunction> addWorkerFunction(@RequestBody SecurityWorkerFunctionDto securityWorkerFunctionDto) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        log.debug("Site project: {}", securityWorkerFunctionDto);
            SecurityWorkerFunction securityWorkerFunction = securityWorkerFunctionService.addWorkerFunction(securityWorkerFunctionDto);
            auditLogService.AuditWorkerFunction(securityWorkerFunction);
            return ResponseEntity.ok(securityWorkerFunction);
    }

    @GetMapping
    public ResponseEntity<List<SecurityWorkerFunctionDto>> getWorkerFunctions() {
        List<SecurityWorkerFunction> securityWorkerFunctions = securityWorkerFunctionService.getWorkerFunctions();
        return ResponseEntity.ok(securityWorkerFunctions.stream()
                .map(securityWorkerFunctionMapper::toDto)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{workerId}/{functionId}")
    public ResponseEntity<SecurityWorkerFunctionDto> getWorkerFunction(@PathVariable String workerId,@PathVariable String functionId) {
        log.debug("Worker ID: {}", workerId);
        SecurityWorkerFunction WorkerFunction = securityWorkerFunctionService.getWorkerFunction(workerId,functionId);
        return ResponseEntity.ok(securityWorkerFunctionMapper.toDto(WorkerFunction));
    }

}
