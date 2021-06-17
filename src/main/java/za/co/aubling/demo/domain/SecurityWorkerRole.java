package za.co.aubling.demo.domain;

import lombok.*;
import za.co.aubling.demo.id.SecurityWorkerRoleId;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@IdClass(SecurityWorkerRoleId.class)
@Table(name = "security_worker_role")
public class SecurityWorkerRole {

    @Id
    @Column(name = "workerId")
    private String workerId;

    @Id
    @Column(name = "role_id")
    private String roleId;

}
