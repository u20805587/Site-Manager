package za.co.aubling.demo.domain;

import lombok.*;
import za.co.aubling.demo.id.SiteProjectWorkerId;
import za.co.aubling.demo.id.SiteProjectWorkerLogId;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@IdClass(SiteProjectWorkerLogId.class)
@Table(name = "site_project_worker_log")
public class SiteProjectWorkerLog {

    @Id
    @Column (name = "worker_id")
    private Long workerId;

    @Id
    @Column (name = "project_id")
    private Long projectId;

    @Id
    @Column (name = "work_date")
    private Date workDate;

    @Column(name = "hours")
    private BigDecimal hours;

}
