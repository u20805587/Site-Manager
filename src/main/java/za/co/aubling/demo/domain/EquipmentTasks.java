package za.co.aubling.demo.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "task_equipment_type")
public class EquipmentTasks implements Serializable {

    @Id
    @Column(name = "task_id")
    private Long taskId;

    @Id
    @Column(name = "equipment_id")
    private Long equipmentID;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(Long equipmentID) {
        this.equipmentID = equipmentID;
    }
}
