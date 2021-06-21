package za.co.aubling.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import za.co.aubling.demo.domain.SiteProjectWorkerLog;
import za.co.aubling.demo.dto.SiteProjectWorkerLogDto;
import za.co.aubling.demo.mapper.SiteProjectWorkerLogMapper;
import za.co.aubling.demo.service.AuditLogService;
import za.co.aubling.demo.service.SiteProjectWorkerLogService;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@Controller
@RequestMapping("/api/projectworkerlog")
public class SiteProjectWorkerLogController {

    private final SiteProjectWorkerLogMapper siteProjectWorkerLogMapper;

    private final SiteProjectWorkerLogService siteProjectWorkerLogService;

    private final AuditLogService auditLogService;


    public SiteProjectWorkerLogController(SiteProjectWorkerLogService siteProjectWorkerLogService,
                                          SiteProjectWorkerLogMapper siteProjectWorkerLogMapper,
                                          AuditLogService auditLogService) {
        this.siteProjectWorkerLogMapper = siteProjectWorkerLogMapper;
        this.siteProjectWorkerLogService = siteProjectWorkerLogService;
        this.auditLogService = auditLogService;
    }

    @PostMapping
    public ResponseEntity<SiteProjectWorkerLog> addProjectWorkerLog(@RequestBody SiteProjectWorkerLogDto siteProjectWorkerLogDto) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        SiteProjectWorkerLog siteProjectWorkerLog = siteProjectWorkerLogService.addProjectWorkerLog(siteProjectWorkerLogDto);
        return ResponseEntity.ok(siteProjectWorkerLog);
    }

    @GetMapping
    public ResponseEntity<List<SiteProjectWorkerLogDto>> getProjectWorkerLogs() {
        List<SiteProjectWorkerLog> siteProjectWorkerLogs = siteProjectWorkerLogService.getProjectWorkerLogs();
        return ResponseEntity.ok(siteProjectWorkerLogs.stream()
                .map(siteProjectWorkerLogMapper::toDto)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{workerId}/{projectId}/{workDate}")
    public ResponseEntity<SiteProjectWorkerLogDto> getProjectWorkerLog(@PathVariable Long workerId,
                                                                       @PathVariable Long projectId,
                                                                       @PathVariable Date workerDate) {
        SiteProjectWorkerLog siteProjectWorkerLog = siteProjectWorkerLogService.getProjectWorkerLog(workerId,projectId,workerDate);
        return ResponseEntity.ok(siteProjectWorkerLogMapper.toDto(siteProjectWorkerLog));
    }

}
