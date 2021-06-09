package za.co.aubling.demo.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/project")
public class SiteProjectController {

    private final SiteProjectMapper siteProjectMapper;

    private final SiteProjectService siteProjectService;

    public SiteProjectController(SiteProjectService siteProjectService, SiteProjectMapper siteProjectMapper) {
        this.siteProjectService = siteProjectService;
        this.siteProjectMapper = siteProjectMapper;
    }

    @PostMapping
    public ResponseEntity<SiteProject> addSiteProject(@RequestBody SiteProjectDto siteProjectDto) {
        log.debug("Site project: {}", siteProjectDto);
        SiteProject siteProject = siteProjectService.addSiteProject(siteProjectDto);
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
