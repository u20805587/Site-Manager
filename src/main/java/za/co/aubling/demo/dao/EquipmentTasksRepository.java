package za.co.aubling.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.aubling.demo.domain.EquipmentTasks;

public interface EquipmentTasksRepository extends JpaRepository<EquipmentTasks, Long> {
}
