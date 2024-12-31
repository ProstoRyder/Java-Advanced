package model;

import annotation.SerializedField;
import annotation.SerializedType;

/**
 * The {@code Smartphone} class represents a smartphone with a model and price.
 * It is annotated with {@link SerializedType} and {@link SerializedField}
 * to define custom names for serialization fields.
 *
 * <p>The class has the following fields:</p>
 * <ul>
 *     <li>{@code model}: The model name of the smartphone</li>
 *     <li>{@code price}: The price of the smartphone</li>
 * </ul>
 *
 * @see annotation.SerializedType
 * @see annotation.SerializedField
 */
@SerializedType(name = "smartphone")
public class Smartphone {

    @SerializedField(name = "phone_model")
    private String model;

    @SerializedField(name = "phone_price")
    private double price;

    /**
     * Constructs a {@code Smartphone} with the given model and price.
     */
    public Smartphone(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }
}
