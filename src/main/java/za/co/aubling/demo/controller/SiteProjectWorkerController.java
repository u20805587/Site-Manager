package za.co.aubling.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import za.co.aubling.demo.domain.SiteProjectWorker;
import za.co.aubling.demo.dto.SiteProjectWorkerDto;
import za.co.aubling.demo.mapper.SiteProjectWorkerMapper;
import za.co.aubling.demo.service.AuditLogService;
import za.co.aubling.demo.service.SiteProjectWorkerService;
import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@Controller
@RequestMapping("/api/workerproject")
public class SiteProjectWorkerController {

    private final SiteProjectWorkerMapper siteProjectWorkerMapper;

    private final SiteProjectWorkerService siteProjectWorkerService;

    private final AuditLogService auditLogService;


    public SiteProjectWorkerController(SiteProjectWorkerService siteProjectWorkerService,
                                          SiteProjectWorkerMapper siteProjectWorkerMapper,
                                          AuditLogService auditLogService) {
        this.siteProjectWorkerMapper = siteProjectWorkerMapper;
        this.siteProjectWorkerService = siteProjectWorkerService;
        this.auditLogService = auditLogService;
    }

    @PostMapping
    public ResponseEntity<SiteProjectWorker> addProjectWorker(@RequestBody SiteProjectWorkerDto siteProjectWorkerDto) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        SiteProjectWorker siteProjectWorker = siteProjectWorkerService.addProjectWorker(siteProjectWorkerDto);
        return ResponseEntity.ok(siteProjectWorker);
    }

    @GetMapping
    public ResponseEntity<List<SiteProjectWorkerDto>> getProjectWorkers() {
        List<SiteProjectWorker> siteProjectWorkers = siteProjectWorkerService.getProjectWorkers();
        return ResponseEntity.ok(siteProjectWorkers.stream()
                .map(siteProjectWorkerMapper::toDto)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{workerId}/{projectId}")
    public ResponseEntity<SiteProjectWorkerDto> getProjectWorker(@PathVariable Long workerId,@PathVariable Long projectId) {
        SiteProjectWorker siteProjectWorker = siteProjectWorkerService.getProjectWorker(workerId,projectId);
        return ResponseEntity.ok(siteProjectWorkerMapper.toDto(siteProjectWorker));
    }

}
