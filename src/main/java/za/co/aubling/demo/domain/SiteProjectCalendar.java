package za.co.aubling.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "site_project_calendar")
public class SiteProjectCalendar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private SiteProject siteProject;

    @Column(name = "work_date")
    private Timestamp workDate;

    @Column(name = "working_day")
    private String workingDay;

    @Column(name = "notes")
    private String notes;

}
