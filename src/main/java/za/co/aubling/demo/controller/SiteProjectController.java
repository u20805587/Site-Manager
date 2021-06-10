package za.co.aubling.demo.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.aubling.demo.domain.SiteProject;
import za.co.aubling.demo.dto.SiteProjectDto;
import za.co.aubling.demo.mapper.SiteProjectMapper;
import za.co.aubling.demo.service.SiteProjectService;

import za.co.aubling.demo.domain.AuditLog;
import za.co.aubling.demo.dto.AuditLogDto;
import za.co.aubling.demo.service.AuditLogService;

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

    private final AuditLogDto auditLogDto;

    public SiteProjectController(SiteProjectService siteProjectService, SiteProjectMapper siteProjectMapper, AuditLogService auditLogService, AuditLogDto auditLogDto) {
        this.siteProjectService = siteProjectService;
        this.siteProjectMapper = siteProjectMapper;
        this.auditLogService = auditLogService;
        this.auditLogDto = auditLogDto;
    }

    @PostMapping
    public ResponseEntity<SiteProject> addSiteProject(@RequestBody SiteProjectDto siteProjectDto) {
        log.debug("Site project: {}", siteProjectDto);
        SiteProject siteProject = siteProjectService.addSiteProject(siteProjectDto);

        auditLogDto.setKeyId("site_project~" + siteProject.getId());
        auditLogDto.setModifiedBy("AUBREY");
        auditLogDto.setAction("Insert");
        auditLogDto.setModificationNo(1);
        auditLogDto.setTableName("site_project");
        auditLogDto.setModificationTimestamp(new Date());
        auditLogDto.setKeyColumns("ProjectId");

        auditLogService.addAuditLog(auditLogDto);
        return ResponseEntity.ok(siteProject);
    }

    @GetMapping
    public ResponseEntity<List<SiteProjectDto>> getProjects() {
        List<SiteProject> siteProjects = siteProjectService.getProjects();
        return ResponseEntity.ok(siteProjects.stream()
                .map(siteProjectMapper::toDto)
                .collect(Collectors.toList()));
    }

}
