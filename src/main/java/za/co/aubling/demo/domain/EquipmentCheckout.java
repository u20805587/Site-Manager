package za.co.aubling.demo.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "equipment_checkout")
public class EquipmentCheckout implements Serializable {

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

    public Long getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(Long referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public Equipment getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Equipment equipmentId) {
        this.equipmentId = equipmentId;
    }

    public SiteProject getProjectId() {
        return projectId;
    }

    public void setProjectId(SiteProject projectId) {
        this.projectId = projectId;
    }

    public SiteWorker getWorkerId() {
        return workerId;
    }

    public void setWorkerId(SiteWorker workerId) {
        this.workerId = workerId;
    }

    public String getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getReturned() {
        return returned;
    }

    public void setReturned(String returned) {
        this.returned = returned;
    }

    public String getDateAcquired() {
        return dateAcquired;
    }

    public void setDateAcquired(String dateAcquired) {
        this.dateAcquired = dateAcquired;
    }
}
