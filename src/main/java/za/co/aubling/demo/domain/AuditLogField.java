package za.co.aubling.demo.domain;

import lombok.*;
import za.co.aubling.demo.id.AuditLogFieldId;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@IdClass(AuditLogFieldId.class)
@Table(name = "audit_log_field")
public class AuditLogField {

    @Id
    @Column(name = "key_id")
    private String keyId;

    @Id
    @Column(name = "modification_no")
    private Integer modificationNo;

    @Id
    @Column(name = "field_name")
    private String fieldName;

    @Column(name = "old_value")
    private String oldValue;

    @Column(name = "new_value")
    private String newValue;
}
