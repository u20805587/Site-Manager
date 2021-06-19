package za.co.aubling.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.aubling.demo.domain.SecurityRole;
import za.co.aubling.demo.domain.SiteProject;
import za.co.aubling.demo.domain.SiteWorker;
import za.co.aubling.demo.dto.SecurityRoleDto;
import za.co.aubling.demo.dto.SiteProjectDto;
import za.co.aubling.demo.dto.SiteWorkerDto;
import za.co.aubling.demo.mapper.SiteWorkerMapper;
import za.co.aubling.demo.service.SiteWorkerService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/worker")
public class SiteWorkerController {

    private final SiteWorkerService workerService;
    private final SiteWorkerMapper siteWorkerMapper;

    public SiteWorkerController(SiteWorkerService siteWorkerService, SiteWorkerMapper siteWorkerMapper) {
        this.workerService = siteWorkerService;
        this.siteWorkerMapper = siteWorkerMapper;
    }

    @PostMapping
    public ResponseEntity<SiteWorker> addSiteWorker(@RequestBody SiteWorkerDto siteWorkerDto) {
        SiteWorker siteWorker = workerService.addSiteWorker(siteWorkerDto);
        return ResponseEntity.ok(siteWorker);
    }

    @GetMapping
    public ResponseEntity<List<SiteWorkerDto>> getSiteWorkers() {
        List<SiteWorker> siteProjects = workerService.getWorkers();
        return ResponseEntity.ok(siteProjects.stream()
                .map(siteWorkerMapper::toDto)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{workerId}")
    public ResponseEntity<SiteWorkerDto> getWorker(@PathVariable Long workerId) {
        SiteWorker worker = workerService.getWorker(workerId);
        return ResponseEntity.ok(siteWorkerMapper.toDto(worker));
    }

}