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
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "equipment_checkout")
public class EquipmentCheckout {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "reference_number")
    private Long referenceNumber;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

    @ManyToOne
    @JoinColumn (name = "project_id")
    private SiteProject siteProject;

    @ManyToOne
    @JoinColumn (name = "worker_id")
    private SiteWorker siteWorker;

    @Column(name = "checkout_date")
    private Timestamp checkoutDate;

    @Column(name = "return_date")
    private Timestamp returnDate;

    @Column(name = "returned")
    private String returned;

    @Column(name = "date_acquired")
    private Timestamp dateAcquired;

}
