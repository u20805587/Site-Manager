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

}
