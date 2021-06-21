package za.co.aubling.demo.dto;

import lombok.*;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Repository
public class SiteProjectWorkerDto implements Serializable {

    private Long workerId;
    private Long projectId;
    private BigDecimal hourlyRate;


}
