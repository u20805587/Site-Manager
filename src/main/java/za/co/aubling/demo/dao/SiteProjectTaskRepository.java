package za.co.aubling.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.aubling.demo.domain.SiteProjectTask;
import za.co.aubling.demo.id.SiteProjectTaskId;

public interface SiteProjectTaskRepository extends JpaRepository<SiteProjectTask, SiteProjectTaskId> {
}
