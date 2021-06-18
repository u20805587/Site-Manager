package za.co.aubling.demo.domain;

import lombok.*;
import za.co.aubling.demo.id.SecurityRoleFunctionId;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@IdClass(SecurityRoleFunctionId.class)
@Table(name = "security_role_function")
public class SecurityRoleFunction {

    @Id
    @Column(name = "role_id")
    private String roleId;

    @Id
    @Column(name = "function_id")
    private String functionId;

    @Column(name = "insert")
    private String insert;

    @Column(name = "modify")
    private String modify;

    @Column(name = "delete")
    private String delete;

}
