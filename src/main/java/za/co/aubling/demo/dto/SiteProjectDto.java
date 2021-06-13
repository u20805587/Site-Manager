package za.co.aubling.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SiteProjectDto implements Serializable {

    private Long   id;
    private String name;
    private String description;
    private String status;
    private String notes;
    private BigDecimal estimatedCost;
    private Timestamp acquiredDate;
    private Timestamp startDate;
    private Timestamp endDate;
    private Integer defaultDailyHours;
    private Integer maximumAllowedHours;
    private Timestamp estimatedStartDate;
    private Timestamp estimatedEndDate;

}
