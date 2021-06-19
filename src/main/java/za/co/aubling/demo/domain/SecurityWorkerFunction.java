package za.co.aubling.demo.domain;

import lombok.*;
import za.co.aubling.demo.id.SecurityWorkerFunctionId;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@IdClass(SecurityWorkerFunctionId.class)
@Table(name = "security_worker_function")
public class SecurityWorkerFunction {

    @Id
    @Column(name = "worker_id")
    private String workerId;

    @Id
    @Column(name = "function_id")
    private String functionId;

    @Column(name = "insert")
    private String insert;

    @Column(name = "modify")
    private String modify;

    @Column(name = "delete")
    private String delete;

    @Column(name = "view")
    private String view;

}
