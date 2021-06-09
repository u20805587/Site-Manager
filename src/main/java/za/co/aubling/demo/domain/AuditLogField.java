package za.co.aubling.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "audit_log_field")
public class AuditLogField {

    @Id
    @Column(name = "key_id")
    private String keyId;

    @Column(name = "modification_no")
    private Long modificationNo;

    @Column(name = "field_name")
    private String fieldName;

    @Column(name = "old_value")
    private String oldValue;

    @Column(name = "new_value")
    private String newValue;
}
