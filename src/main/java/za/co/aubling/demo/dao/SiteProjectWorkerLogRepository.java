package za.co.aubling.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.aubling.demo.domain.SiteProjectWorkerLog;
import za.co.aubling.demo.dto.SiteProjectWorkerLogDto;
import za.co.aubling.demo.id.SiteProjectTaskLogId;
import za.co.aubling.demo.id.SiteProjectWorkerLogId;

public interface SiteProjectWorkerLogRepository extends JpaRepository<SiteProjectWorkerLog, SiteProjectWorkerLogId> {
}
