package za.co.aubling.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.aubling.demo.domain.SecurityWorkerRole;
import za.co.aubling.demo.id.SecurityWorkerRoleId;

import java.util.Optional;

@Repository
public interface SecurityWorkerRoleRepository extends JpaRepository<SecurityWorkerRole, SecurityWorkerRoleId> {

}
