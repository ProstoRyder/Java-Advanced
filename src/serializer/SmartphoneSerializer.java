package serializer;

import model.Smartphone;

/**
 * The {@code SmartphoneSerializer} class provides methods to serialize {@link model.Smartphone} objects
 * to JSON and XML formats.
 *
 * <p>This class includes methods to convert a {@code Smartphone} object into its corresponding JSON and XML
 * string representations:</p>
 * <ul>
 *     <li>{@link #toJson(Smartphone)}: Serializes a {@code Smartphone} object to a JSON string.</li>
 *     <li>{@link #toXml(Smartphone)}: Serializes a {@code Smartphone} object to an XML string.</li>
 * </ul>
 */
public class SmartphoneSerializer {

    /**
     * Serializes a {@code Smartphone} object to a JSON string.
     *
     * @param smartphone the {@code Smartphone} object to be serialized
     * @return a JSON string representing the {@code Smartphone}
     */
    public static String toJson(Smartphone smartphone) {
        return String.format("{\"phone_model\": \"%s\", \"phone_price\": %.2f}", smartphone.getModel(), smartphone.getPrice());
    }

    /**
     * Serializes a {@code Smartphone} object to an XML string.
     *
     * @param smartphone the {@code Smartphone} object to be serialized
     * @return an XML string representing the {@code Smartphone}
     */
    public static String toXml(Smartphone smartphone) {
        return String.format("<smartphone><phone_model>%s</phone_model><phone_price>%.2f</phone_price></smartphone>", smartphone.getModel(), smartphone.getPrice());
    }
}
