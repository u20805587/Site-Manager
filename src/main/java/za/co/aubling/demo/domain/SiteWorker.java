package za.co.aubling.demo.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "site_worker")
public class SiteWorker implements Serializable {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "worker_id")
    private Long workerId;

    @ManyToOne
    @JoinColumn (name = "worker_cat_id")
    private SiteWorkerCategory workerCatId;

    @Column(name = "name")
    private String name;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "surname")
    private String surname;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "gender")
    private String gender;

    @Column(name = "id_number")
    private String idNumber;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "address_line1")
    private String addressLine1;

    @Column(name = "address_line2")
    private String addressLine2;

    @Column(name = "addressLine3")
    private String addressLine3;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "hourly_rate")
    private BigDecimal hourlyRate;

    @Column(name = "state_code")
    private String stateCode;

}
