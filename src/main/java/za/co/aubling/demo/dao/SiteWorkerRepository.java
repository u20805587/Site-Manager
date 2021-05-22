package za.co.aubling.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.aubling.demo.domain.SiteWorker;

public interface SiteWorkerRepository extends JpaRepository<SiteWorker, Long> {
}
