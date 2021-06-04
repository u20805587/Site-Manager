package za.co.aubling.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "site_worker_category")
public class SiteWorkerCategory implements Serializable {

    @Id
    private Long id;

    @Column(name = "cat_description")
    private String description;
}
