package cgi.internship.project.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class SeatsMatrixConverter implements AttributeConverter<boolean[][], String> {

    private final ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    @Override
    public String convertToDatabaseColumn(boolean[][] attribute) {
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    @Override
    public boolean[][] convertToEntityAttribute(String dbData) {
        try {
            return objectMapper.readValue(dbData, boolean[][].class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
