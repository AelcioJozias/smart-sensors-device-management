package com.jozias.smartsensors.device.management.api.controller;

import com.jozias.smartsensors.device.management.api.model.SensorInput;
import com.jozias.smartsensors.device.management.api.model.SensorOutput;
import com.jozias.smartsensors.device.management.common.IdGenerator;
import com.jozias.smartsensors.device.management.domain.model.Sensor;
import com.jozias.smartsensors.device.management.domain.model.SensorId;
import com.jozias.smartsensors.device.management.domain.repository.SensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/sensors")
@RequiredArgsConstructor
public class SensorController {

    private final SensorRepository sensorRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SensorOutput create(@RequestBody SensorInput input) {
        Sensor sensor = Sensor.builder()
                .id(new SensorId(IdGenerator.generateTSID()))
                .name(input.getName())
                .ip(input.getIp())
                .location(input.getLocation())
                .protocol(input.getProtocol())
                .model(input.getModel())
                .enabled(input.isEnabled())
                .build();

        Sensor sensorPersisted = sensorRepository.saveAndFlush(sensor);

        return SensorOutput.builder()
                .id(sensorPersisted.getId().getValue())
                .name(sensor.getName())
                .ip(sensor.getIp())
                .location(sensor.getLocation())
                .protocol(sensor.getProtocol())
                .model(sensor.getModel())
                .enabled(sensor.isEnabled())
                .build();
    }

}
