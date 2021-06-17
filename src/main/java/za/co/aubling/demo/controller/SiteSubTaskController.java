package za.co.aubling.demo.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.aubling.demo.domain.SiteSubTask;
import za.co.aubling.demo.dto.SiteSubTaskDto;
import za.co.aubling.demo.mapper.SiteSubTaskMapper;
import za.co.aubling.demo.service.SiteSubTaskService;

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
@RequestMapping("/api/subtask")
public class SiteSubTaskController {

    private final SiteSubTaskMapper siteSubTaskMapper;

    private final SiteSubTaskService siteSubTaskService;

    private final AuditLogService auditLogService;

    private final AuditLogDto auditLogDto;

    private final AuditLogFieldService auditLogFieldService;

    private final AuditLogFieldDto auditLogFieldDto;

    public SiteSubTaskController(SiteSubTaskService siteSubTaskService,
                              SiteSubTaskMapper siteSubTaskMapper,
                              AuditLogService auditLogService,
                              AuditLogDto auditLogDto,
                              AuditLogFieldService auditLogFieldService,
                              AuditLogFieldDto auditLogFieldDto) {
        this.siteSubTaskService = siteSubTaskService;
        this.siteSubTaskMapper = siteSubTaskMapper;
        this.auditLogService = auditLogService;
        this.auditLogDto = auditLogDto;
        this.auditLogFieldService = auditLogFieldService;
        this.auditLogFieldDto = auditLogFieldDto;
    }

    @PostMapping
    public ResponseEntity<SiteSubTask> addSiteSubTask(@RequestBody SiteSubTaskDto siteSubTaskDto) {
        log.debug("Site SubTask: {}", siteSubTaskDto);
        SiteSubTask siteSubTask = siteSubTaskService.addSiteSubTask(siteSubTaskDto);

        auditLogDto.setKeyId("site_SubTask~" + siteSubTask.getId());
        auditLogDto.setModifiedBy("AUBREY");
        auditLogDto.setAction("Insert");
        auditLogDto.setModificationNo(1);
        auditLogDto.setTableName("site_SubTask");
        auditLogDto.setModificationTimestamp(new Date());
        auditLogDto.setKeyColumns("Id");

        auditLogFieldDto.setKeyId("site_SubTask~" + siteSubTask.getId());
        auditLogFieldDto.setFieldName("subTaskName");
        auditLogFieldDto.setNewValue(siteSubTask.getSubTaskName());
        auditLogFieldDto.setModificationNo(1);

        auditLogService.addAuditLog(auditLogDto);
        auditLogFieldService.addAuditLogField(auditLogFieldDto);
        return ResponseEntity.ok(siteSubTask);
    }

    @GetMapping
    public ResponseEntity<List<SiteSubTaskDto>> getSubTasks() {
        List<SiteSubTask> siteSubTasks = siteSubTaskService.getSubTasks();
        return ResponseEntity.ok(siteSubTasks.stream()
                .map(siteSubTaskMapper::toDto)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{SubTaskId}")
    public ResponseEntity<SiteSubTaskDto> getSubTask(@PathVariable Long SubTaskId) {
        SiteSubTask SubTask = siteSubTaskService.getSubTask(SubTaskId);
        return ResponseEntity.ok(siteSubTaskMapper.toDto(SubTask));
    }

}
