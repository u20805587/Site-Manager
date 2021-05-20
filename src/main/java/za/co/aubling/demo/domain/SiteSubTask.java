package za.co.aubling.demo.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "site_sub_task")
public class SiteSubTask implements Serializable {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @JoinColumn (name = "sub_task_id")
    private Long subTaskId;

    @ManyToOne
    @JoinColumn (name = "task_id")
    private SiteTask taskId;

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
