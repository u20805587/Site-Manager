package za.co.aubling.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.aubling.demo.domain.SiteProject;
import za.co.aubling.demo.dto.SiteProjectDto;
import za.co.aubling.demo.mapper.SiteProjectMapper;
import za.co.aubling.demo.service.SiteProjectService;

import za.co.aubling.demo.domain.AuditLog;
import za.co.aubling.demo.dto.AuditLogDto;
import za.co.aubling.demo.service.AuditLogService;

import za.co.aubling.demo.domain.AuditLogField;
import za.co.aubling.demo.dto.AuditLogFieldDto;
import za.co.aubling.demo.service.AuditLogFieldService;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/project")
public class SiteProjectController {

    private final SiteProjectMapper siteProjectMapper;

    private final SiteProjectService siteProjectService;

    private final AuditLogService auditLogService;


    public SiteProjectController(SiteProjectService siteProjectService,
                                 SiteProjectMapper siteProjectMapper,
                                 AuditLogService auditLogService) {
        this.siteProjectService = siteProjectService;
        this.siteProjectMapper = siteProjectMapper;
        this.auditLogService = auditLogService;
    }

    @PostMapping
    public ResponseEntity<SiteProject> addSiteProject(@RequestBody SiteProjectDto siteProjectDto) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        log.debug("Site project: {}", siteProjectDto);
            SiteProject siteProject = siteProjectService.addSiteProject(siteProjectDto);
            auditLogService.AuditSiteProject(siteProject);
            return ResponseEntity.ok(siteProject);
    }

    @GetMapping
    public ResponseEntity<List<SiteProjectDto>> getProjects() {
        List<SiteProject> siteProjects = siteProjectService.getProjects();
        return ResponseEntity.ok(siteProjects.stream()
                .map(siteProjectMapper::toDto)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<SiteProjectDto> getProject(@PathVariable Long projectId) {
        SiteProject project = siteProjectService.getProject(projectId);
        return ResponseEntity.ok(siteProjectMapper.toDto(project));
    }

}
