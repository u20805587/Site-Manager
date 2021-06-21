package za.co.aubling.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import za.co.aubling.demo.domain.SiteProjectTask;
import za.co.aubling.demo.dto.SiteProjectTaskDto;
import za.co.aubling.demo.mapper.SiteProjectTaskMapper;
import za.co.aubling.demo.service.AuditLogService;
import za.co.aubling.demo.service.SiteProjectTaskService;
import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@Controller
@RequestMapping("/api/projecttask")
public class SiteProjectTaskController {

    private final SiteProjectTaskMapper siteProjectTaskMapper;

    private final SiteProjectTaskService siteProjectTaskService;

    private final AuditLogService auditLogService;


    public SiteProjectTaskController(SiteProjectTaskService siteProjectTaskService,
                                       SiteProjectTaskMapper siteProjectTaskMapper,
                                       AuditLogService auditLogService) {
        this.siteProjectTaskMapper = siteProjectTaskMapper;
        this.siteProjectTaskService = siteProjectTaskService;
        this.auditLogService = auditLogService;
    }

    @PostMapping
    public ResponseEntity<SiteProjectTask> addProjectTask(@RequestBody SiteProjectTaskDto siteProjectTaskDto) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        SiteProjectTask siteProjectTask = siteProjectTaskService.addProjectTask(siteProjectTaskDto);
        return ResponseEntity.ok(siteProjectTask);
    }

    @GetMapping
    public ResponseEntity<List<SiteProjectTaskDto>> getProjectTasks() {
        List<SiteProjectTask> siteProjectTasks = siteProjectTaskService.getProjectTasks();
        return ResponseEntity.ok(siteProjectTasks.stream()
                .map(siteProjectTaskMapper::toDto)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{subtaskId}/{projectId}")
    public ResponseEntity<SiteProjectTaskDto> getProjectTask(@PathVariable Long subtaskId,@PathVariable Long projectId) {
        SiteProjectTask siteProjectTask = siteProjectTaskService.getProjectTask(subtaskId,projectId);
        return ResponseEntity.ok(siteProjectTaskMapper.toDto(siteProjectTask));
    }

}
