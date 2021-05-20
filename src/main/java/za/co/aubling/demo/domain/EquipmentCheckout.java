package za.co.aubling.demo.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "equipment_checkout")
public class EquipmentCheckout {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "reference_number")
    private Long referenceNumber;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipment equipmentId;

    @ManyToOne
    @JoinColumn (name = "project_id")
    private SiteProject projectId;

    @ManyToOne
    @JoinColumn (name = "worker_id")
    private SiteWorker workerId;

    @Column(name = "checkout_date")
    private String checkoutDate;

    @Column(name = "return_date")
    private String returnDate;

    @Column(name = "returned")
    private String returned;

    @Column(name = "date_acquired")
    private String dateAcquired;
}
