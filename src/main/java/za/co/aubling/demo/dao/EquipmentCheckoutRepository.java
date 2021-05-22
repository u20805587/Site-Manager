package za.co.aubling.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.aubling.demo.domain.EquipmentCheckout;

public interface EquipmentCheckoutRepository extends JpaRepository<EquipmentCheckout, Long> {
}
