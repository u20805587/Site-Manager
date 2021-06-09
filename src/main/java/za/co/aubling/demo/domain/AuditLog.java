package za.co.aubling.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "audit_log")
public class AuditLog {

    @Id
    @Column(name = "key_id")
    private String keyId;

    @Column(name = "modification_no")
    private Long modificationNo;

    @Column(name = "table_name")
    private String tableName;

    @Column(name = "key_columns")
    private String keyColumns;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "modification_timestamp")
    private Timestamp modificationTimestamp;

    @Column(name = "action")
    private String action;
}
