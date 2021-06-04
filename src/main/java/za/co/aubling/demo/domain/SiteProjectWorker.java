package za.co.aubling.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "site_project_worker")
public class SiteProjectWorker implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn (name = "project_id")
    private SiteProject siteProject;

    @ManyToOne
    @JoinColumn (name = "worker_id")
    private SiteWorker siteWorker;

    @Column(name = "hourly_rate")
    private BigDecimal hourlyRate;

}
