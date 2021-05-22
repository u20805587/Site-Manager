package za.co.aubling.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.aubling.demo.domain.EquipmentModel;

public interface EquipmentModelRepository extends JpaRepository<EquipmentModel, String> {
}
