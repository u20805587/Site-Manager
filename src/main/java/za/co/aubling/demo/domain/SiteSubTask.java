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

    public Long getSubTaskId() {
        return subTaskId;
    }

    public void setSubTaskId(Long subTaskId) {
        this.subTaskId = subTaskId;
    }

    public SiteTask getTaskId() {
        return taskId;
    }

    public void setTaskId(SiteTask taskId) {
        this.taskId = taskId;
    }

    public String getSubTaskName() {
        return subTaskName;
    }

    public void setSubTaskName(String subTaskName) {
        this.subTaskName = subTaskName;
    }

    public String getSubTaskDescription() {
        return subTaskDescription;
    }

    public void setSubTaskDescription(String subTaskDescription) {
        this.subTaskDescription = subTaskDescription;
    }

    public BigDecimal getMeterCost() {
        return meterCost;
    }

    public void setMeterCost(BigDecimal meterCost) {
        this.meterCost = meterCost;
    }

    public BigDecimal getSquareMeterCost() {
        return squareMeterCost;
    }

    public void setSquareMeterCost(BigDecimal squareMeterCost) {
        this.squareMeterCost = squareMeterCost;
    }

    public BigDecimal getCubicMeterCost() {
        return cubicMeterCost;
    }

    public void setCubicMeterCost(BigDecimal cubicMeterCost) {
        this.cubicMeterCost = cubicMeterCost;
    }
}
