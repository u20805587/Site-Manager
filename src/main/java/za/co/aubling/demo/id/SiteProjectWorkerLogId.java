package za.co.aubling.demo.id;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class SiteProjectWorkerLogId implements Serializable {

    private Long workerId;
    private Long projectId;
    private Date workDate;

    public SiteProjectWorkerLogId() {
    }

    public SiteProjectWorkerLogId(Long workerId, Long projectId, Date workDate) {
        this.workerId = workerId;
        this.projectId = projectId;
        this.workDate = workDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SiteProjectWorkerLogId siteProjectWorkerLogId = (SiteProjectWorkerLogId) o;
        return workerId.equals(siteProjectWorkerLogId.workerId) &&
                projectId.equals(siteProjectWorkerLogId.projectId) &&
                workDate.equals(siteProjectWorkerLogId.workDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workerId, projectId, workDate);
    }
}