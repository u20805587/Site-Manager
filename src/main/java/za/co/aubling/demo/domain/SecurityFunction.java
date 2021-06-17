package za.co.aubling.demo.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "security_function")
public class SecurityFunction implements Serializable {

    @Id
    @Column(name = "function_id")
    private String functionID;

    @Column(name = "description")
    private String description;

}
