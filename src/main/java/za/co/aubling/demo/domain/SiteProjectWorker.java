package za.co.aubling.demo.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "site_project_worker")
public class SiteProjectWorker implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn (name = "project_id")
    private SiteProject projectId;

    @Id
    @ManyToOne
    @JoinColumn (name = "worker_id")
    private SiteWorker workerId;

    @Column(name = "hourly_rate")
    private BigDecimal hourlyRate;

    public SiteProject getProjectId() {
        return projectId;
    }

    public void setProjectId(SiteProject projectId) {
        this.projectId = projectId;
    }

    public SiteWorker getWorkerId() {
        return workerId;
    }

    public void setWorkerId(SiteWorker workerId) {
        this.workerId = workerId;
    }

    public BigDecimal getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(BigDecimal hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
