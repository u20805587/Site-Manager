package za.co.aubling.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.aubling.demo.domain.SecurityFunction;


public interface SecurityFunctionRepository extends JpaRepository<SecurityFunction, String> {
}
