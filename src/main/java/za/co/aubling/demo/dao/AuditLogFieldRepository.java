package za.co.aubling.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.aubling.demo.domain.AuditLogField;

public interface AuditLogFieldRepository extends JpaRepository<AuditLogField, String> {
}
