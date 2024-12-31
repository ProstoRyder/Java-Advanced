package utils;

import annotations.JsonField;
import annotations.XmlField;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Utility class for serializing objects into JSON and XML formats using reflection.
 * The class uses the annotations {@link JsonField} and {@link XmlField} to map the fields
 * of the object to their corresponding JSON or XML representations.
 */
public class ReflectionSerializer {

    /**
     * Serializes an object into its JSON representation using reflection and the {@link JsonField} annotation.
     * The field names in the resulting JSON are based on the values provided in the {@link JsonField} annotations.
     *
     * @param obj the object to serialize
     * @return the JSON string representation of the object
     * @throws IllegalAccessException if a field is not accessible during reflection
     */
    public static String toJson(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Map<String, Object> jsonMap = new HashMap<>();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField annotation = field.getAnnotation(JsonField.class);
                field.setAccessible(true);
                jsonMap.put(annotation.value(), field.get(obj));
            }
        }

        return jsonMap.toString().replace("=", ":");
    }

    /**
     * Serializes an object into its XML representation using reflection and the {@link XmlField} annotation.
     * The field names in the resulting XML are based on the values provided in the {@link XmlField} annotations.
     *
     * @param obj the object to serialize
     * @return the XML string representation of the object
     * @throws IllegalAccessException if a field is not accessible during reflection
     */
    public static String toXml(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        StringBuilder xmlBuilder = new StringBuilder();

        xmlBuilder.append("<").append(clazz.getSimpleName()).append(">\n");

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(XmlField.class)) {
                XmlField annotation = field.getAnnotation(XmlField.class);
                field.setAccessible(true);
                xmlBuilder.append("  <").append(annotation.value()).append(">")
                        .append(field.get(obj))
                        .append("</").append(annotation.value()).append(">\n");
            }
        }

        xmlBuilder.append("</").append(clazz.getSimpleName()).append(">");
        return xmlBuilder.toString();
    }
}
