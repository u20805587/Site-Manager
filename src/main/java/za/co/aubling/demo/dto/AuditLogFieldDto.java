package za.co.aubling.demo.dto;

import lombok.*;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Repository
public class AuditLogFieldDto implements Serializable {

    private String keyId;
    private Integer modificationNo;
    private String fieldName;
    private String oldValue;
    private String newValue;
}
