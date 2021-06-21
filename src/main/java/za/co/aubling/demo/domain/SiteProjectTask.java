package za.co.aubling.demo.domain;

import lombok.*;
import za.co.aubling.demo.id.SiteProjectTaskId;
import za.co.aubling.demo.id.SiteProjectWorkerId;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@IdClass(SiteProjectTaskId.class)
@Table(name = "site_project_task")
public class SiteProjectTask implements Serializable {

    @Id
    @Column (name = "subtask_id")
    private Long subtaskId;


    @Id
    @Column (name = "project_id")
    private Long projectId;

    @Column(name = "length")
    private BigDecimal length;

    @Column(name = "width")
    private BigDecimal width;

    @Column(name = "height")
    private BigDecimal height;

    @Column(name = "unit")
    private String unit;

    @Column(name = "status")
    private String status;

}
