package za.co.aubling.demo.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "site_worker_category")
public class SiteWorkerCategory implements Serializable {

    @Id
    @Column(name = "worker_cat_id")
    private String workerCatId;

    @Column(name = "cat_description")
    private String catDescription;

}
