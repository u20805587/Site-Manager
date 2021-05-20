package za.co.aubling.demo.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "site_project_task")
public class SiteProjectTask implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn (name = "project_id")
    private SiteProject projectId;

    @Id
    @ManyToOne
    @JoinColumn (name = "sub_task_id")
    private SiteSubTask subTaskId;

    @Column(name = "length")
    private BigDecimal length;

    @Column(name = "width")
    private BigDecimal width;

    @Column(name = "height")
    private BigDecimal height;

    @Column(name = "unit")
    private String unit;

    @Column(name = "status")
    private String status;

    public SiteProject getProjectId() {
        return projectId;
    }

    public void setProjectId(SiteProject projectId) {
        this.projectId = projectId;
    }

    public SiteSubTask getSubTaskId() {
        return subTaskId;
    }

    public void setSubTaskId(SiteSubTask subTaskId) {
        this.subTaskId = subTaskId;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
