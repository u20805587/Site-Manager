package za.co.aubling.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.aubling.demo.domain.SecurityRoleFunction;
import za.co.aubling.demo.id.SecurityRoleFunctionId;

public interface SecurityRoleFunctionRepository extends JpaRepository<SecurityRoleFunction, SecurityRoleFunctionId> {

}
