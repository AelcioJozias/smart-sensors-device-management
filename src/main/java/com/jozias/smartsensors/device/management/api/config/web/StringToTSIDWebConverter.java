package com.jozias.smartsensors.device.management.api.config.web;

import io.hypersistence.tsid.TSID;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

/**
 * Esse converter serve para na requisição web ele transformar a string enviada em um TSID automaticamente.
 * Ele é registrado na classe @{@link WebConfig}
 *
 */
public class StringToTSIDWebConverter implements Converter<String, TSID> {

    @Override
    public TSID convert(@Nullable String source) {
        return TSID.from(source);
    }

}
