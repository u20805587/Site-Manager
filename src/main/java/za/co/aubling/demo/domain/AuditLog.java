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
@IdClass(AuditLog.class)
@Table(name = "audit_log")
public class AuditLog implements Serializable {

    @Id
    @Column(name = "key_id")
    private String keyId;

    @Id
    @Column(name = "modification_no")
    private Integer modificationNo;

    @Column(name = "table_name")
    private String tableName;

    @Column(name = "key_columns")
    private String keyColumns;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "modification_timestamp")
    private Date modificationTimestamp;

    @Column(name = "action")
    private String action;
}
