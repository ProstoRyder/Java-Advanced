package serializer;

import model.Person;

/**
 * The {@code PersonSerializer} class provides methods to serialize a {@link model.Person} object
 * to JSON and XML formats.
 *
 * <p>This class includes the following methods:</p>
 * <ul>
 *     <li>{@link #toJson(Person)}: Serializes a {@code Person} object to a JSON string.</li>
 *     <li>{@link #toXml(Person)}: Serializes a {@code Person} object to an XML string.</li>
 * </ul>
 */
public class PersonSerializer {

    /**
     * Serializes a {@code Person} object to a JSON string.
     *
     * @param person the {@code Person} object to be serialized
     * @return a JSON string representing the {@code Person}
     */
    public static String toJson(Person person) {
        return String.format("{\"person_name\": \"%s\", \"person_age\": %d}", person.getName(), person.getAge());
    }

    /**
     * Serializes a {@code Person} object to an XML string.
     *
     * @param person the {@code Person} object to be serialized
     * @return an XML string representing the {@code Person}
     */
    public static String toXml(Person person) {
        return String.format("<person><person_name>%s</person_name><person_age>%d</person_age></person>", person.getName(), person.getAge());
    }
}
