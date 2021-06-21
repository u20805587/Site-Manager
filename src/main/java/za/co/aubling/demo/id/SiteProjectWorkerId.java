package za.co.aubling.demo.id;

import java.io.Serializable;
import java.util.Objects;

public class SiteProjectWorkerId implements Serializable {

    private Long workerId;
    private Long projectId;

    public SiteProjectWorkerId() {
    }

    public SiteProjectWorkerId(Long workerId, Long projectId) {
        this.workerId = workerId;
        this.projectId = projectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SiteProjectWorkerId siteProjectWorkerId = (SiteProjectWorkerId) o;
        return workerId.equals(siteProjectWorkerId.workerId) &&
                projectId.equals(siteProjectWorkerId.projectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workerId, projectId);
    }
}