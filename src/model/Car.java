package model;

import annotation.SerializedField;
import annotation.SerializedType;

/**
 * The {@code Car} class represents a vehicle with a model and year.
 * It is annotated with {@link SerializedType} and {@link SerializedField}
 * to define custom names for serialization fields.
 *
 * <p>The class has the following fields:</p>
 * <ul>
 *     <li>{@code model}: The car's model</li>
 *     <li>{@code year}: The car's manufacturing year</li>
 * </ul>
 *
 * @see annotation.SerializedType
 * @see annotation.SerializedField
 */
@SerializedType(name = "vehicle")
public class Car {

    @SerializedField(name = "car_model")
    private String model;

    @SerializedField(name = "car_year")
    private int year;

    /**
     * Constructs a {@code Car} with the given model and year.
     */
    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
}
