package za.co.aubling.demo.id;

import java.io.Serializable;
import java.util.Objects;

public class AuditLogFieldId implements Serializable {

    private String keyId;
    private Integer modificationNo;
    private String fieldName;

    public AuditLogFieldId() {
    }

    public AuditLogFieldId(String keyId, Integer modificationNo, String fieldName) {
        this.keyId = keyId;
        this.modificationNo = modificationNo;
        this.fieldName = fieldName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuditLogFieldId auditLogFieldId = (AuditLogFieldId) o;
        return keyId.equals(auditLogFieldId.keyId) &&
                modificationNo.equals(auditLogFieldId.modificationNo) &&
                fieldName.equals(auditLogFieldId.fieldName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyId, modificationNo, fieldName);
    }
}