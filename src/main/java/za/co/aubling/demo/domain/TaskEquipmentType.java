package za.co.aubling.demo.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "task_equipment_type")
public class TaskEquipmentType implements Serializable {

    @Id
    @Column(name = "task_id")
    private Long taskId;

    @Id
    @Column(name = "type")
    private String type;

}
