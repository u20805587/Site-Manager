package za.co.aubling.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.aubling.demo.domain.SiteProjectTaskLog;
import za.co.aubling.demo.id.SiteProjectTaskLogId;

public interface SiteProjectTaskLogRepository extends JpaRepository<SiteProjectTaskLog, SiteProjectTaskLogId> {
}
