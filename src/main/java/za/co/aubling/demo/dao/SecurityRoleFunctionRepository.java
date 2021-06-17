package za.co.aubling.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.aubling.demo.domain.SecurityRoleFunction;
import za.co.aubling.demo.id.SecurityRoleFunctionId;

import java.util.Optional;

@Repository
public interface SecurityRoleFunctionRepository extends JpaRepository<SecurityRoleFunction, SecurityRoleFunctionId> {

}
