package za.co.aubling.demo.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "equipment_type")
public class EquipmentType implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn (name = "task_id")
    private SiteTask taskId;

    @Id
    @Column(name = "type")
    private String type;

    public SiteTask getTaskId() {
        return taskId;
    }

    public void setTaskId(SiteTask taskId) {
        this.taskId = taskId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
