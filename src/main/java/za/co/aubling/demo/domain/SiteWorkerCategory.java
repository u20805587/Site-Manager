package za.co.aubling.demo.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "site_worker_category")
public class SiteWorkerCategory implements Serializable {

    @Id
    @Column(name = "worker_cat_id")
    private String workerCatId;

    @Column(name = "cat_description")
    private String catDescription;

    public String getWorkerCatId() {
        return workerCatId;
    }

    public void setWorkerCatId(String workerCatId) {
        this.workerCatId = workerCatId;
    }

    public String getCatDescription() {
        return catDescription;
    }

    public void setCatDescription(String catDescription) {
        this.catDescription = catDescription;
    }
}
