package za.co.aubling.demo.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "site_project_calendar")
public class SiteProjectCalendar implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn (name = "project_id")
    private SiteProject projectId;

    @Id
    @Column (name = "work_date")
    private Date workDate;

    @Column(name = "working_day")
    private String workingDay;

    @Column(name = "notes")
    private String notes;

    public SiteProject getProjectId() {
        return projectId;
    }

    public void setProjectId(SiteProject projectId) {
        this.projectId = projectId;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public String getWorkingDay() {
        return workingDay;
    }

    public void setWorkingDay(String workingDay) {
        this.workingDay = workingDay;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
