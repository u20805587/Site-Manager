package za.co.aubling.demo.dto;

import lombok.*;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Repository
public class SiteProjectWorkerLogDto implements Serializable {

    private Long workerId;
    private Long projectId;
    private Date workDate;
    private BigDecimal hours;


}
