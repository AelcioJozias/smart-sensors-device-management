package com.jozias.smartsensors.device.management.domain.model;

import io.hypersistence.tsid.TSID;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

/**
 * SensorId é um identificador customizado para a entidade Sensor.
 * <p>
 * O JPA não aplica automaticamente AttributeConverter em identificadores (chave primária),
 * apenas em atributos comuns das entidades. Por isso, criamos esta classe como @Embeddable,
 * permitindo que o campo interno 'value' (do tipo TSID) seja convertido pelo TSIDToLongJPAAttributeConverter
 * ao persistir no banco de dados.
 * <p>
 * Dessa forma, conseguimos usar um tipo customizado como identificador, aproveitando o converter
 * para persistir o valor corretamente como Long no banco e reconstruir o TSID ao ler.
 */
@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SensorId implements Serializable {

    /**
     * O campo 'value' armazena o TSID real do identificador.
     * <p>
     * O converter TSIDToLongJPAAttributeConverter será aplicado automaticamente neste campo,
     * pois ele é um atributo simples de uma classe @Embeddable.
     * <p>
     * Se tentássemos usar TSID diretamente como identificador da entidade, o converter não seria aplicado.
     */
    private TSID value;

    /**
     * Construtor para criar SensorId a partir de um TSID.
     */
    public SensorId(TSID value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    /**
     * Construtor para criar SensorId a partir de um Long.
     * Útil para reconstruir o TSID a partir do valor persistido no banco.
     */
    public SensorId(Long value) {
        Objects.requireNonNull(value);
        this.value = TSID.from(value);
    }

    /**
     * Construtor para criar SensorId a partir de uma String.
     * Útil para conversões e integrações externas.
     */
    public SensorId(String value) {
        Objects.requireNonNull(value);
        this.value = TSID.from(value);
    }

    @Override
    public String toString() {
        return "SensorId{" +
                "value=" + value.toString() +
                '}';
    }
}
