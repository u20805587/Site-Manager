package za.co.aubling.demo.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "equipment_checkout")
public class EquipmentCheckout implements Serializable {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "reference_number")
    private Long referenceNumber;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Long equipmentId;

    @ManyToOne
    @JoinColumn (name = "project_id")
    private Long projectId;

    @ManyToOne
    @JoinColumn (name = "worker_id")
    private Long workerId;

    @Column(name = "checkout_date")
    private Date checkoutDate;

    @Column(name = "return_date")
    private Date returnDate;

    @Column(name = "returned")
    private String returned;

    @Column(name = "date_acquired")
    private Date dateAcquired;

    public Long getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(Long referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getReturned() {
        return returned;
    }

    public void setReturned(String returned) {
        this.returned = returned;
    }

    public Date getDateAcquired() {
        return dateAcquired;
    }

    public void setDateAcquired(Date dateAcquired) {
        this.dateAcquired = dateAcquired;
    }
}
