package za.co.aubling.demo.id;

import java.io.Serializable;
import java.util.Objects;

public class SiteProjectTaskId implements Serializable {

    private Long subtaskId;
    private Long projectId;

    public SiteProjectTaskId() {
    }

    public SiteProjectTaskId(Long subtaskId, Long projectId) {
        this.subtaskId = subtaskId;
        this.projectId = projectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SiteProjectTaskId siteProjectTaskId = (SiteProjectTaskId) o;
        return subtaskId.equals(siteProjectTaskId.subtaskId) &&
                projectId.equals(siteProjectTaskId.projectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subtaskId, projectId);
    }
}