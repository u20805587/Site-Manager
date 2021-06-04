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
@Table(name = "site_project_task_log")
public class SiteProjectTaskLog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn (name = "project_id")
    private SiteProject siteProject;

    @ManyToOne
    @JoinColumn (name = "sub_task_id")
    private SiteSubTask siteSubTask;

    @Column (name = "work_date")
    private Timestamp workDate;

    @Column(name = "length")
    private BigDecimal length;

    @Column(name = "width")
    private BigDecimal width;

    @Column(name = "height")
    private BigDecimal height;

}
