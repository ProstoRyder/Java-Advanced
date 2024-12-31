package serializer;

import model.Car;

/**
 * The {@code CarSerializer} class provides methods to serialize a {@link model.Car} object
 * to JSON and XML formats.
 *
 * <p>This class includes the following methods:</p>
 * <ul>
 *     <li>{@link #toJson(Car)}: Serializes a {@code Car} object to a JSON string.</li>
 *     <li>{@link #toXml(Car)}: Serializes a {@code Car} object to an XML string.</li>
 * </ul>
 */
public class CarSerializer {

    /**
     * Serializes a {@code Car} object to a JSON string.
     *
     * @param car the {@code Car} object to be serialized
     * @return a JSON string representing the {@code Car}
     */
    public static String toJson(Car car) {
        return String.format("{\"car_model\": \"%s\", \"car_year\": %d}", car.getModel(), car.getYear());
    }

    /**
     * Serializes a {@code Car} object to an XML string.
     *
     * @param car the {@code Car} object to be serialized
     * @return an XML string representing the {@code Car}
     */
    public static String toXml(Car car) {
        return String.format("<vehicle><car_model>%s</car_model><car_year>%d</car_year></vehicle>", car.getModel(), car.getYear());
    }
}
