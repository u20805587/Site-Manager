package za.co.aubling.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import za.co.aubling.demo.service.AccessService;
import za.co.aubling.demo.service.SiteWorkerService;
import java.sql.SQLException;

@Slf4j
@RestController
@RequestMapping("/api/access")
public class AccessController {

    private final AccessService accessService;

    public AccessController(AccessService accessService
            ,SiteWorkerService siteWorkerService) {
        this.accessService = accessService;
    }

    @GetMapping("/{username}/{functionId}")
    public boolean getAccess(@PathVariable String username, @PathVariable String functionId) throws SQLException, NoSuchFieldException, ClassNotFoundException, IllegalAccessException {
        return accessService.grantAccess(username,functionId);
    }
}
