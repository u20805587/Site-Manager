package za.co.aubling.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuditLogDto implements Serializable {

    private String keyId;
    private String action;
    private Long   modificationNo;
    private String keyColumns;
    private String modifiedBy;
    private Timestamp modificationTimestamp;
    private String tableName;
}
