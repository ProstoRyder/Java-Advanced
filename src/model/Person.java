package model;

import annotation.SerializedField;
import annotation.SerializedType;

/**
 * The {@code Person} class represents an individual with a name and age.
 * It is annotated with {@link SerializedType} and {@link SerializedField}
 * to define custom names for serialization fields.
 *
 * <p>The class has the following fields:</p>
 * <ul>
 *     <li>{@code name}: The person's name</li>
 *     <li>{@code age}: The person's age</li>
 * </ul>
 *
 * @see annotation.SerializedType
 * @see annotation.SerializedField
 */
@SerializedType(name = "person")
public class Person {

    @SerializedField(name = "person_name")
    private String name;

    @SerializedField(name = "person_age")
    private int age;

    /**
     * Constructs a {@code Person} with the given name and age.
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
