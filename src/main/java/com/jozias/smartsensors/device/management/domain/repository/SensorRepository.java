package com.jozias.smartsensors.device.management.domain.repository;

import com.jozias.smartsensors.device.management.domain.model.Sensor;
import com.jozias.smartsensors.device.management.domain.model.SensorId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, SensorId> {
}
