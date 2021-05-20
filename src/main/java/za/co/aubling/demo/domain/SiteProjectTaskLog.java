package za.co.aubling.demo.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "site_project_task_log")
public class SiteProjectTaskLog implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn (name = "project_id")
    private SiteProject projectId;

    @Id
    @ManyToOne
    @JoinColumn (name = "sub_task_id")
    private SiteSubTask subTaskId;

    @Id
    @Column (name = "work_date")
    private Date workDate;

    @Column(name = "length")
    private BigDecimal length;

    @Column(name = "width")
    private BigDecimal width;

    @Column(name = "height")
    private BigDecimal height;

}
