package za.co.aubling.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import za.co.aubling.demo.domain.SiteProjectTaskLog;
import za.co.aubling.demo.dto.SiteProjectTaskLogDto;
import za.co.aubling.demo.mapper.SiteProjectTaskLogMapper;
import za.co.aubling.demo.service.AuditLogService;
import za.co.aubling.demo.service.SiteProjectTaskLogService;
import java.io.*;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@Controller
@RequestMapping("/api/projecttasklog")
public class SiteProjectTaskLogController {

    private final SiteProjectTaskLogMapper siteProjectTaskLogMapper;

    private final SiteProjectTaskLogService siteProjectTaskLogService;

    private final AuditLogService auditLogService;


    public SiteProjectTaskLogController(SiteProjectTaskLogService siteProjectTaskLogService,
                                     SiteProjectTaskLogMapper siteProjectTaskLogMapper,
                                     AuditLogService auditLogService) {
        this.siteProjectTaskLogMapper = siteProjectTaskLogMapper;
        this.siteProjectTaskLogService = siteProjectTaskLogService;
        this.auditLogService = auditLogService;
    }

    @PostMapping
    public ResponseEntity<SiteProjectTaskLog> addProjectTaskLog(@RequestBody SiteProjectTaskLogDto siteProjectTaskLogDto) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        SiteProjectTaskLog siteProjectTaskLog = siteProjectTaskLogService.addProjectTaskLog(siteProjectTaskLogDto);
        return ResponseEntity.ok(siteProjectTaskLog);
    }

    @GetMapping
    public ResponseEntity<List<SiteProjectTaskLogDto>> getProjectTaskLogs() {
        List<SiteProjectTaskLog> siteProjectTaskLogs = siteProjectTaskLogService.getProjectTaskLogs();
        return ResponseEntity.ok(siteProjectTaskLogs.stream()
                .map(siteProjectTaskLogMapper::toDto)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{subtaskId}/{projectId}/{workDate}")
    public ResponseEntity<SiteProjectTaskLogDto> getProjectTaskLog(@PathVariable Long subtaskId,
                                                                   @PathVariable Long projectId,
                                                                   @PathVariable Date workDate) {
        SiteProjectTaskLog siteProjectTaskLog = siteProjectTaskLogService.getProjectTaskLog(subtaskId,projectId, workDate);
        return ResponseEntity.ok(siteProjectTaskLogMapper.toDto(siteProjectTaskLog));
    }

}
