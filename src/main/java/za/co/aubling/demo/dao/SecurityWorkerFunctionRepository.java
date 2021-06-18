package za.co.aubling.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.aubling.demo.domain.SecurityWorkerFunction;
import za.co.aubling.demo.id.SecurityWorkerFunctionId;

public interface SecurityWorkerFunctionRepository extends JpaRepository<SecurityWorkerFunction, SecurityWorkerFunctionId> {
}
