package com.jozias.smartsensors.device.management.api.config.jackson;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;
import io.hypersistence.tsid.TSID;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 Registra o serializador @com.jozias.smartsensors.device.management.api.config.jackson.TSIDToStringSerializer
 customizado para o TSID no Jackson
 */
@Configuration
public class TSIDJacksonConfig {

    @Bean
    public Module tsIdModule() {
        SimpleModule module = new SimpleModule();
        module.addSerializer(TSID.class, new TSIDToStringSerializer());
        return module;
    }

}