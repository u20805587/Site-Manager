package za.co.aubling.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.aubling.demo.domain.TaskEquipmentType;

public interface TaskEquipmentTypeRepository extends JpaRepository<TaskEquipmentType, Long> {
}
