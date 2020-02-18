package edu.skku.dealistic.converter;

import javax.persistence.AttributeConverter;
import java.util.List;

/**
 * Hibernate Converter
 * Main Features:
 * - Convert comma separated value to Java list. or reverse.
 *
 * @author Junhyun Kim
 */
public class ListToCsvConverter implements AttributeConverter<List<String>, String> {
    @Override
    public String convertToDatabaseColumn(List<String> strings) {
        if(strings == null || strings.isEmpty()) return null;
        return String.join(",", strings);
    }

    @Override
    public List<String> convertToEntityAttribute(String s) {
        if(s == null || "".equals(s)) return List.of();
        return List.of(s.split(","));
    }
}
