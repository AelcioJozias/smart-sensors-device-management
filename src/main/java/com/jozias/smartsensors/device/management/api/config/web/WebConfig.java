package com.jozias.smartsensors.device.management.api.config.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Registra conversores personalizados para o contexto web.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {


    /**
     * Método para adicionar formatadores e conversores personalizados ao registro.
     * @param registry Registro de formatadores onde o conversor personalizado é adicionado.
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToTSIDWebConverter());
    }
}
