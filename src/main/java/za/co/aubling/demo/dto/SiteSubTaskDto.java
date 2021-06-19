package za.co.aubling.demo.dto;

import lombok.*;
import za.co.aubling.demo.domain.SiteTask;

import javax.persistence.Column;
import java.io.Serializable;
import java.math.BigDecimal;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SiteSubTaskDto implements Serializable {

    private Long id;
    private Long siteTask;
    private String subTaskName;
    private String subTaskDescription;
    private BigDecimal meterCost;
    private BigDecimal squareMeterCost;
    private BigDecimal cubicMeterCost;
}
