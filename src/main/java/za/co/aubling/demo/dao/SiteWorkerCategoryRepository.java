package za.co.aubling.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.aubling.demo.domain.SiteWorkerCategory;

public interface SiteWorkerCategoryRepository extends JpaRepository<SiteWorkerCategory, Long> {
}
