package za.co.aubling.demo.domain;

import lombok.*;
import za.co.aubling.demo.id.SecurityWorkerFunctionId;
import za.co.aubling.demo.id.SiteProjectWorkerId;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@IdClass(SiteProjectWorkerId.class)
@Table(name = "site_project_worker")
public class SiteProjectWorker implements Serializable {

    @Id
    @Column (name = "worker_id")
    private Long workerId;

    @Id
    @Column (name = "project_id")
    private Long projectId;

    @Column(name = "hourly_rate")
    private BigDecimal hourlyRate;

}
