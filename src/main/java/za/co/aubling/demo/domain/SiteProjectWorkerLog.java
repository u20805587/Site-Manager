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
@Table(name = "site_project_worker_log")
public class SiteProjectWorkerLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn (name = "project_id")
    private SiteProject siteProject;

    @ManyToOne
    @JoinColumn (name = "worker_id")
    private SiteWorker siteWorker;

    @Column (name = "work_date")
    private Timestamp workDate;

    @Column(name = "hours")
    private BigDecimal hours;

}
