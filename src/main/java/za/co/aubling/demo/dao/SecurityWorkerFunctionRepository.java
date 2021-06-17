package za.co.aubling.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.aubling.demo.domain.SecurityWorkerFunction;
import za.co.aubling.demo.id.SecurityWorkerFunctionId;

import java.util.Optional;

@Repository
public interface SecurityWorkerFunctionRepository extends JpaRepository<SecurityWorkerFunction, SecurityWorkerFunctionId> {
}
