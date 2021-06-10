package za.co.aubling.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Repository
public class AuditLogDto implements Serializable {

    private String keyId;
    private String action;
    private Integer modificationNo;
    private String keyColumns;
    private String modifiedBy;
    private Date modificationTimestamp;
    private String tableName;
}
