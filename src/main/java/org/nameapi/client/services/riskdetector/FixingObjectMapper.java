package org.nameapi.client.services.riskdetector;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import org.jetbrains.annotations.NotNull;
import org.nameapi.ontology5.services.riskdetector.DisguiseRiskType;
import org.nameapi.ontology5.services.riskdetector.FakeRiskType;
import org.nameapi.ontology5.services.riskdetector.RiskType;

import java.io.IOException;

/**
 * Knows how to handle {@link RiskType} implementations.
 */
public class FixingObjectMapper {

    private FixingObjectMapper() {
        throw new AssertionError();
    }

    @NotNull
    public static ObjectMapper create() {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(RiskType.class, new CustomDeserializer());
        objectMapper.registerModule(module);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new GuavaModule());
        return objectMapper;
    }

    static class CustomDeserializer extends JsonDeserializer<RiskType> {
        @Override
        public RiskType deserialize(JsonParser p, DeserializationContext c) throws IOException {
            String value = p.getValueAsString();
            return getValueByCode(value);
        }

        /**
         * As of 2023-05-18, it knows and handles only two {@link RiskType} implementations:
         * {@link FakeRiskType} and {@link DisguiseRiskType}.
         * If new implementations are added, this method must be updated.
         * <p>
         * Also, as of 2023-05-18, we have two values with the same name:
         * {@link FakeRiskType#OTHER} and {@link DisguiseRiskType#OTHER}.
         * If we have to deserialize "OTHER", we don't know which one to use.
         * But we don't want to throw, because we only need it in the tests.
         * So we return {@link FakeRiskType#OTHER}.
         *
         * @param value the text value of the enum
         * @return the enum value or empty if not found
         */
        @NotNull
        private RiskType getValueByCode(String value) {
            value = value.toUpperCase();
            FakeRiskType[] values = FakeRiskType.values();
            for (FakeRiskType fakeRiskType : values) {
                if (fakeRiskType.name().equals(value)) {
                    return fakeRiskType;
                }
            }
            DisguiseRiskType[] disguiseRiskTypes = DisguiseRiskType.values();
            for (DisguiseRiskType disguiseRiskType : disguiseRiskTypes) {
                if (disguiseRiskType.name().equals(value)) {
                    return disguiseRiskType;
                }
            }
            throw new IllegalArgumentException("Cannot deserialize RiskType from value " + value);
        }
    }
}
