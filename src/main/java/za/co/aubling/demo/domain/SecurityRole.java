package za.co.aubling.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "security_role")
public class SecurityRole implements Serializable {

    @Id
    @Column(name = "role_id")
    private String roleId;

    @Column(name = "description")
    private String description;

}
