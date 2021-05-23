package za.co.aubling.demo.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "equipment_model")
public class EquipmentModel implements Serializable {

    @Id
    @Column(name = "brand")
    private String brand;

    @Id
    @Column(name = "model")
    private String model;

    @Column(name = "type")
    private String type;

    @Column(name = "year")
    private String year;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
