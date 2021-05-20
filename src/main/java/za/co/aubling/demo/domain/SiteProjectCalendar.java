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

}
