package za.co.aubling.demo.service;
import java.sql.*;

import org.springframework.stereotype.Service;
import za.co.aubling.demo.dao.AuditLogRepository;
import za.co.aubling.demo.domain.AuditLog;
import za.co.aubling.demo.domain.SiteProject;
import za.co.aubling.demo.dto.AuditLogDto;


import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AuditLogBackService {

    private final AuditLogRepository AuditLogRepository;

    public AuditLogBackService(AuditLogRepository AuditLogRepository) {
        this.AuditLogRepository = AuditLogRepository;
    }

    @Transactional
    public AuditLog addAuditLog(AuditLogDto auditLogDto) {
        AuditLog auditLog = AuditLog.builder()
                .keyId(auditLogDto.getKeyId())
                .action(auditLogDto.getAction())
                .modificationNo(auditLogDto.getModificationNo())
                .keyColumns(auditLogDto.getKeyColumns())
                .modifiedBy(auditLogDto.getModifiedBy())
                .modificationTimestamp(auditLogDto.getModificationTimestamp())
                .tableName(auditLogDto.getTableName())
                .build();
        return AuditLogRepository.save(auditLog);
    }

    public AuditLog AuditSiteProject(SiteProject siteProject) throws ClassNotFoundException, SQLException {
        String myDriver = "org.gjt.mm.mysql.Driver";
        String myUrl = "jdbc:postgresql://localhost:5432/SiteProject";
        Class.forName(myDriver);
        String query = "SELECT COALESCE(max(modification_no),1) modificationNo FROM public.audit_log where key_id = 'site_project~" + siteProject.getId() + "'";
        Connection conn = DriverManager.getConnection(myUrl, "postgres", "Cerato#4");
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        AuditLog auditLog = AuditLog.builder()
                            .keyId("site_project~" + siteProject.getId())
                            .action("I")
                            .modificationNo(rs.getInt("modificationNo"))
                            .keyColumns("id~")
                            .modifiedBy("Aubrey")
                            .modificationTimestamp(new Date())
                            .tableName("site_project")
                            .build();

        return AuditLogRepository.save(auditLog);
    }

    public List<AuditLog> getAuditLog() {
        return AuditLogRepository.findAll();
    }

    public Optional<AuditLog> getAuditLog(String keyId) {
        return AuditLogRepository.findById(keyId);
    }

}
