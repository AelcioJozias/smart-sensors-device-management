package com.jozias.smartsensors.device.management.api.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SensorInput {
    @NotEmpty
    private String name;
    @NotEmpty
    private String ip;
    @NotEmpty
    private String location;
    @NotEmpty
    private String protocol;
    @NotEmpty
    private String model;
}
