package za.co.aubling.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "site_sub_task")
public class SiteSubTask implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "task_id")
    private Long siteTask;

    @Column(name = "sub_task_name")
    private String subTaskName;

    @Column(name = "sub_task_description")
    private String subTaskDescription;

    @Column(name = "meter_cost")
    private BigDecimal meterCost;

    @Column(name = "square_meter_cost")
    private BigDecimal squareMeterCost;

    @Column(name = "cubic_meter_cost")
    private BigDecimal cubicMeterCost;

}
