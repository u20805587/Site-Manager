package za.co.aubling.demo.service;
import java.sql.*;
import java.io.*;
import java.lang.*;
import jdk.nashorn.internal.lookup.MethodHandleFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import za.co.aubling.demo.dao.*;
import za.co.aubling.demo.domain.*;
import za.co.aubling.demo.domain.SiteProject;
import za.co.aubling.demo.dto.AuditLogDto;
import za.co.aubling.demo.dto.SiteProjectDto;
import java.lang.reflect.*;
import za.co.aubling.demo.service.AuditLogFieldService;

import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AuditLogBackService {

    private final AuditLogRepository AuditLogRepository;
    private final AuditLogFieldService auditLogFieldService;
    private final SiteProjectService siteProjectService;

    public AuditLogBackService(AuditLogRepository AuditLogRepository,
                           AuditLogFieldService auditLogFieldService,
                           SiteProjectService siteProjectService) {
        this.AuditLogRepository = AuditLogRepository;
        this.auditLogFieldService = auditLogFieldService;
        this.siteProjectService = siteProjectService;
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

    public void AuditSiteProject(SiteProjectDto siteProjectDto) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        SiteProject siteProject = siteProjectService.getProject(siteProjectDto.getId());
        AuditSiteProject(siteProject);
    }

    public AuditLog AuditSiteProject(SiteProject siteProject) throws ClassNotFoundException, SQLException, NoSuchFieldException, IllegalAccessException {
        String myDriver = "org.postgresql.Driver";
        String myUrl = "jdbc:postgresql://localhost:5432/SiteProject";
        Class.forName(myDriver);
        String query = "SELECT COALESCE(max(modification_no),0) modificationNo FROM public.audit_log where key_id = 'site_project~" + siteProject.getId() + "'";
        Connection conn = DriverManager.getConnection(myUrl, "postgres", "Cerato#4");
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        Integer modNo = 0;
        String action = "Insert";
        if (rs.next()) {
            modNo = rs.getInt("modificationNo") + 1;
        }

        if (modNo != 1) {
            action = "Update";
        }

        query = "SELECT id, date_acquired, project_description, end_date, estimated_end_date, estimated_start_date, " +
                "project_name, notes, project_cost, start_date, status, default_daily_hours, estimated_cost, " +
                "maximum_allowed_hours FROM site_project where id = " + 23;//+ siteProject.getId()+";";

        rs = st.executeQuery(query);

        if (rs.next()) {
            modNo = modNo;
        }

        AuditLog auditLog = AuditLog.builder()
                .keyId("site_project~" + siteProject.getId())
                .action(action)
                .modificationNo(modNo)
                .keyColumns("id~")
                .modifiedBy("Aubrey")
                .modificationTimestamp(new Date())
                .tableName("site_project")
                .build();

        Field[] allFields = siteProject.getClass().getDeclaredFields();

        for (Field field : allFields) {
            field.setAccessible(true);
            try {
                AuditLogField auditFieldLog = AuditLogField.builder()
                        .keyId("site_project~" + siteProject.getId())
                        .modificationNo(modNo)
                        .fieldName(field.getName())
                        .newValue(field.get(siteProject).toString())
                        .build();
                auditLogFieldService.auditField(auditFieldLog);
            }
            catch (Exception e){
                System.out.println("Something went wrong." + field.getName()+" "+e.fillInStackTrace());
            }

        }

        return AuditLogRepository.save(auditLog);
    }

    public List<AuditLog> getAuditLog() {
        return AuditLogRepository.findAll();
    }

    public Optional<AuditLog> getAuditLog(String keyId) {
        return AuditLogRepository.findById(keyId);
    }

}
