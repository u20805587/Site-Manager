package za.co.aubling.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.aubling.demo.domain.SiteProject;

public interface SiteProjectRepository extends JpaRepository<SiteProject, Long> {
}
