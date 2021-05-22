package za.co.aubling.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.aubling.demo.domain.SiteProjectTask;

public interface SiteProjectTaskRepository extends JpaRepository<SiteProjectTask, Long> {
}
