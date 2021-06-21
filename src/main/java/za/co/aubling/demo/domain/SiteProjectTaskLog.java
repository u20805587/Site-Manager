package za.co.aubling.demo.domain;

import lombok.*;
import za.co.aubling.demo.id.SiteProjectTaskId;
import za.co.aubling.demo.id.SiteProjectTaskLogId;

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
@IdClass(SiteProjectTaskLogId.class)
@Table(name = "site_project_task_log")
public class SiteProjectTaskLog implements Serializable {

    @Id
    @Column (name = "project_id")
    private Long projectId;

    @Id
    @Column (name = "sub_task_id")
    private Long subtaskId;

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
