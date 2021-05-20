package za.co.aubling.demo.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "equipment")
public class Equipment {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "equipment_id")
    private Long equipmentId;

    @Column(name = "equipment_name")
    private String taskName;

    @Column(name = "equipment_description")
    private String equipmentDescription;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "status")
    private String status;

    @Column(name = "date_acquired")
    private String dateAcquired;

    @Column(name = "cost")
    private BigDecimal cost;

    @Column(name = "service_date")
    private String service_date;

    @Column(name = "next_service_date")
    private String nextServiceDate;

    @Column(name = "serviced")
    private String serviced;
}
