package za.co.aubling.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.aubling.demo.domain.SiteProjectWorker;
import za.co.aubling.demo.id.SiteProjectWorkerId;

public interface SiteProjectWorkerRepository extends JpaRepository<SiteProjectWorker, SiteProjectWorkerId> {
}
