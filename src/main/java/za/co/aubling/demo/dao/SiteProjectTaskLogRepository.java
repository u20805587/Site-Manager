package za.co.aubling.demo.dao;

        import org.springframework.data.jpa.repository.JpaRepository;
        import za.co.aubling.demo.domain.SiteProjectTaskLog;

public interface SiteProjectTaskLogRepository extends JpaRepository<SiteProjectTaskLog, Long> {
}
