package za.co.aubling.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.aubling.demo.domain.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}
