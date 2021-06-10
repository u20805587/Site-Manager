package za.co.aubling.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.aubling.demo.domain.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog, String> {
}
