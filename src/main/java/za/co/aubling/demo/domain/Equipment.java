package za.co.aubling.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "equipment")
public class Equipment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "equipment_name")
    private String name;

    @Column(name = "equipment_description")
    private String description;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "status")
    private String status;

    @Column(name = "date_acquired")
    private Timestamp dateAcquired;

    @Column(name = "cost")
    private BigDecimal cost;

    @Column(name = "service_date")
    private Timestamp serviceDate;

    @Column(name = "next_service_date")
    private Timestamp nextServiceDate;

    @Column(name = "serviced")
    private String serviced;

}
