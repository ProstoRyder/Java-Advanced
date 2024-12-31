package serializer;

import model.Car;
import model.Person;
import model.Smartphone;

/**
 * The {@code ReflectionSerializer} class provides methods to serialize {@link model.Car},
 * {@link model.Person}, and {@link model.Smartphone} objects to JSON and XML formats using reflection.
 *
 * <p>This class includes methods for each model to convert the objects into their corresponding JSON and XML string representations:</p>
 * <ul>
 *     <li>{@link #toJson(Car)}: Serializes a {@code Car} object to a JSON string.</li>
 *     <li>{@link #toXml(Car)}: Serializes a {@code Car} object to an XML string.</li>
 *     <li>{@link #toJson(Person)}: Serializes a {@code Person} object to a JSON string.</li>
 *     <li>{@link #toXml(Person)}: Serializes a {@code Person} object to an XML string.</li>
 *     <li>{@link #toJson(Smartphone)}: Serializes a {@code Smartphone} object to a JSON string.</li>
 *     <li>{@link #toXml(Smartphone)}: Serializes a {@code Smartphone} object to an XML string.</li>
 * </ul>
 */
public class ReflectionSerializer {

    /**
     * Serializes a {@code Car} object to a JSON string.
     *
     * @param car the {@code Car} object to be serialized
     * @return a JSON string representing the {@code Car}
     * @throws IllegalAccessException if the field access is not allowed
     */
    public static String toJson(Car car) throws IllegalAccessException {
        StringBuilder json = new StringBuilder("{");
        json.append(String.format("\"car_model\": \"%s\", \"car_year\": %d", car.getModel(), car.getYear()));
        json.append("}");
        return json.toString();
    }

    /**
     * Serializes a {@code Car} object to an XML string.
     *
     * @param car the {@code Car} object to be serialized
     * @return an XML string representing the {@code Car}
     * @throws IllegalAccessException if the field access is not allowed
     */
    public static String toXml(Car car) throws IllegalAccessException {
        StringBuilder xml = new StringBuilder();
        xml.append("<vehicle>");
        xml.append(String.format("<car_model>%s</car_model><car_year>%d</car_year>", car.getModel(), car.getYear()));
        xml.append("</vehicle>");
        return xml.toString();
    }

    /**
     * Serializes a {@code Person} object to a JSON string.
     *
     * @param person the {@code Person} object to be serialized
     * @return a JSON string representing the {@code Person}
     * @throws IllegalAccessException if the field access is not allowed
     */
    public static String toJson(Person person) throws IllegalAccessException {
        StringBuilder json = new StringBuilder("{");
        json.append(String.format("\"person_name\": \"%s\", \"person_age\": %d", person.getName(), person.getAge()));
        json.append("}");
        return json.toString();
    }

    /**
     * Serializes a {@code Person} object to an XML string.
     *
     * @param person the {@code Person} object to be serialized
     * @return an XML string representing the {@code Person}
     * @throws IllegalAccessException if the field access is not allowed
     */
    public static String toXml(Person person) throws IllegalAccessException {
        StringBuilder xml = new StringBuilder();
        xml.append("<person>");
        xml.append(String.format("<person_name>%s</person_name><person_age>%d</person_age>", person.getName(), person.getAge()));
        xml.append("</person>");
        return xml.toString();
    }

    /**
     * Serializes a {@code Smartphone} object to a JSON string.
     *
     * @param smartphone the {@code Smartphone} object to be serialized
     * @return a JSON string representing the {@code Smartphone}
     * @throws IllegalAccessException if the field access is not allowed
     */
    public static String toJson(Smartphone smartphone) throws IllegalAccessException {
        StringBuilder json = new StringBuilder("{");
        json.append(String.format("\"phone_model\": \"%s\", \"phone_price\": %.2f", smartphone.getModel(), smartphone.getPrice()));
        json.append("}");
        return json.toString();
    }

    /**
     * Serializes a {@code Smartphone} object to an XML string.
     *
     * @param smartphone the {@code Smartphone} object to be serialized
     * @return an XML string representing the {@code Smartphone}
     * @throws IllegalAccessException if the field access is not allowed
     */
    public static String toXml(Smartphone smartphone) throws IllegalAccessException {
        StringBuilder xml = new StringBuilder();
        xml.append("<smartphone>");
        xml.append(String.format("<phone_model>%s</phone_model><phone_price>%.2f</phone_price>", smartphone.getModel(), smartphone.getPrice()));
        xml.append("</smartphone>");
        return xml.toString();
    }
}
