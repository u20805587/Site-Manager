package za.co.aubling.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.aubling.demo.domain.SiteSubTask;

public interface SiteSubTaskRepository extends JpaRepository<SiteSubTask, Long> {
}
