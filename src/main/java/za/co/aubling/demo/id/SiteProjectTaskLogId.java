package za.co.aubling.demo.id;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class SiteProjectTaskLogId implements Serializable {

    private Long subtaskId;
    private Long projectId;
    private Date workDate;

    public SiteProjectTaskLogId() {
    }

    public SiteProjectTaskLogId(Long subtaskId, Long projectId, Date workDate) {
        this.subtaskId = subtaskId;
        this.projectId = projectId;
        this.workDate = workDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SiteProjectTaskLogId siteProjectTaskLogId = (SiteProjectTaskLogId) o;
        return subtaskId.equals(siteProjectTaskLogId.subtaskId) &&
                projectId.equals(siteProjectTaskLogId.projectId) &&
                workDate.equals(siteProjectTaskLogId.workDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subtaskId, projectId, workDate);
    }
}