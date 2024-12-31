package utils;

import items.Laptop;
import items.Movie;
import items.Animal;

import java.lang.reflect.Field;

/**
 * Utility class for serializing objects into JSON and XML formats using reflection.
 * The class provides methods for serializing instances of {@link Laptop}, {@link Movie}, and {@link Animal}.
 * It supports both JSON and XML serialization formats.
 */
public class ManualSerializer {

    /**
     * Serializes a {@link Laptop} object into its JSON representation.
     *
     * @param laptop the {@link Laptop} object to serialize
     * @return the JSON string representation of the {@link Laptop} object
     * @throws IllegalAccessException if a field is not accessible during reflection
     */
    public static String toJson(Laptop laptop) throws IllegalAccessException {
        return String.format("{\"model\": \"%s\", \"processor\": \"%s\", \"storage\": \"%s\"}",
                getFieldValue(laptop, "model"), getFieldValue(laptop, "processor"), getFieldValue(laptop, "storage"));
    }

    /**
     * Serializes a {@link Laptop} object into its XML representation.
     *
     * @param laptop the {@link Laptop} object to serialize
     * @return the XML string representation of the {@link Laptop} object
     * @throws IllegalAccessException if a field is not accessible during reflection
     */
    public static String toXml(Laptop laptop) throws IllegalAccessException {
        return String.format("<laptop><model>%s</model><processor>%s</processor><storage>%s</storage></laptop>",
                getFieldValue(laptop, "model"), getFieldValue(laptop, "processor"), getFieldValue(laptop, "storage"));
    }

    /**
     * Serializes a {@link Movie} object into its JSON representation.
     *
     * @param movie the {@link Movie} object to serialize
     * @return the JSON string representation of the {@link Movie} object
     * @throws IllegalAccessException if a field is not accessible during reflection
     */
    public static String toJson(Movie movie) throws IllegalAccessException {
        return String.format("{\"title\": \"%s\", \"director\": \"%s\", \"releaseYear\": \"%s\"}",
                getFieldValue(movie, "title"), getFieldValue(movie, "director"), getFieldValue(movie, "releaseYear"));
    }

    /**
     * Serializes a {@link Movie} object into its XML representation.
     *
     * @param movie the {@link Movie} object to serialize
     * @return the XML string representation of the {@link Movie} object
     * @throws IllegalAccessException if a field is not accessible during reflection
     */
    public static String toXml(Movie movie) throws IllegalAccessException {
        return String.format("<movie><title>%s</title><director>%s</director><releaseYear>%s</releaseYear></movie>",
                getFieldValue(movie, "title"), getFieldValue(movie, "director"), getFieldValue(movie, "releaseYear"));
    }

    /**
     * Serializes an {@link Animal} object into its JSON representation.
     *
     * @param animal the {@link Animal} object to serialize
     * @return the JSON string representation of the {@link Animal} object
     * @throws IllegalAccessException if a field is not accessible during reflection
     */
    public static String toJson(Animal animal) throws IllegalAccessException {
        return String.format("{\"species\": \"%s\", \"age\": %d, \"habitat\": \"%s\"}",
                getFieldValue(animal, "species"), getFieldValue(animal, "age"), getFieldValue(animal, "habitat"));
    }

    /**
     * Serializes an {@link Animal} object into its XML representation.
     *
     * @param animal the {@link Animal} object to serialize
     * @return the XML string representation of the {@link Animal} object
     * @throws IllegalAccessException if a field is not accessible during reflection
     */
    public static String toXml(Animal animal) throws IllegalAccessException {
        return String.format("<animal><species>%s</species><age>%d</age><habitat>%s</habitat></animal>",
                getFieldValue(animal, "species"), getFieldValue(animal, "age"), getFieldValue(animal, "habitat"));
    }

    /**
     * Retrieves the value of a field in an object using reflection.
     *
     * @param obj        the object whose field value is to be retrieved
     * @param fieldName  the name of the field to retrieve
     * @return the value of the field
     * @throws IllegalAccessException if the field is not accessible or doesn't exist
     */
    private static Object getFieldValue(Object obj, String fieldName) throws IllegalAccessException {
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(obj);
        } catch (NoSuchFieldException e) {
            throw new IllegalAccessException("Field " + fieldName + " not found in class " + obj.getClass().getSimpleName());
        }
    }
}
