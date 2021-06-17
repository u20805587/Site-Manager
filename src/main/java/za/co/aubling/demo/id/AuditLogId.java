package za.co.aubling.demo.id;

import java.io.Serializable;
import java.util.Objects;

public class AuditLogId implements Serializable {

    private String keyId;
    private Integer modificationNo;

    public AuditLogId() {
    }

    public AuditLogId(String keyId, Integer modificationNo) {
        this.keyId = keyId;
        this.modificationNo = modificationNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuditLogId auditLogId = (AuditLogId) o;
        return keyId.equals(auditLogId.keyId) &&
                modificationNo.equals(auditLogId.modificationNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyId, modificationNo);
    }
}