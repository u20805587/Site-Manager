package za.co.aubling.demo.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.aubling.demo.domain.SiteTask;
import za.co.aubling.demo.dto.SiteTaskDto;
import za.co.aubling.demo.mapper.SiteTaskMapper;
import za.co.aubling.demo.service.SiteTaskService;

import za.co.aubling.demo.domain.AuditLog;
import za.co.aubling.demo.dto.AuditLogDto;
import za.co.aubling.demo.service.AuditLogService;

import za.co.aubling.demo.domain.AuditLogField;
import za.co.aubling.demo.dto.AuditLogFieldDto;
import za.co.aubling.demo.service.AuditLogFieldService;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/task")
public class SiteTaskController {

    private final SiteTaskMapper siteTaskMapper;

    private final SiteTaskService siteTaskService;

    private final AuditLogService auditLogService;

    private final AuditLogDto auditLogDto;

    private final AuditLogFieldService auditLogFieldService;

    private final AuditLogFieldDto auditLogFieldDto;

    public SiteTaskController(SiteTaskService siteTaskService,
                                 SiteTaskMapper siteTaskMapper,
                                 AuditLogService auditLogService,
                                 AuditLogDto auditLogDto,
                                 AuditLogFieldService auditLogFieldService,
                                 AuditLogFieldDto auditLogFieldDto) {
        this.siteTaskService = siteTaskService;
        this.siteTaskMapper = siteTaskMapper;
        this.auditLogService = auditLogService;
        this.auditLogDto = auditLogDto;
        this.auditLogFieldService = auditLogFieldService;
        this.auditLogFieldDto = auditLogFieldDto;
    }

    @PostMapping
    public ResponseEntity<SiteTask> addSiteTask(@RequestBody SiteTaskDto siteTaskDto) {
        log.debug("Site Task: {}", siteTaskDto);
        SiteTask siteTask = siteTaskService.addSiteTask(siteTaskDto);

        auditLogDto.setKeyId("site_Task~" + siteTask.getId());
        auditLogDto.setModifiedBy("AUBREY");
        auditLogDto.setAction("Insert");
        auditLogDto.setModificationNo(1);
        auditLogDto.setTableName("site_Task");
        auditLogDto.setModificationTimestamp(new Date());
        auditLogDto.setKeyColumns("Id");

        auditLogFieldDto.setKeyId("site_Task~" + siteTask.getId());
        auditLogFieldDto.setFieldName("name");
        auditLogFieldDto.setNewValue(siteTask.getName());
        auditLogFieldDto.setModificationNo(1);

        auditLogService.addAuditLog(auditLogDto);
        auditLogFieldService.addAuditLogField(auditLogFieldDto);
        return ResponseEntity.ok(siteTask);
    }

    @GetMapping
    public ResponseEntity<List<SiteTaskDto>> getTasks() {
        List<SiteTask> siteTasks = siteTaskService.getTasks();
        return ResponseEntity.ok(siteTasks.stream()
                .map(siteTaskMapper::toDto)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{TaskId}")
    public ResponseEntity<SiteTaskDto> getTask(@PathVariable Long TaskId) {
        SiteTask Task = siteTaskService.getTask(TaskId);
        return ResponseEntity.ok(siteTaskMapper.toDto(Task));
    }

}
