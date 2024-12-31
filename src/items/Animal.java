package items;

import annotations.JsonField;
import annotations.XmlField;

/**
 * Represents an Animal with attributes for species, age, and habitat.
 * This class supports mapping of its fields for both JSON and XML serialization
 * using the {@link JsonField} and {@link XmlField} annotations.
 */
public class Animal {

    /**
     * The species of the animal.
     * Serialized as "species" in JSON and "Species" in XML.
     */
    @JsonField("species")
    @XmlField("Species")
    private String species;

    /**
     * The age of the animal.
     * Serialized as "age" in JSON and "Age" in XML.
     */
    @JsonField("age")
    @XmlField("Age")
    private int age;

    /**
     * The habitat of the animal.
     * Serialized as "habitat" in JSON and "Habitat" in XML.
     */
    @JsonField("habitat")
    @XmlField("Habitat")
    private String habitat;

    /**
     * Constructs a new Animal instance with the specified species, age, and habitat.
     *
     * @param species the species of the animal (e.g., "Lion", "Eagle")
     * @param age     the age of the animal in years
     * @param habitat the habitat of the animal (e.g., "Savannah", "Forest")
     */
    public Animal(String species, int age, String habitat) {
        this.species = species;
        this.age = age;
        this.habitat = habitat;
    }

    /**
     * Gets the species of the animal.
     *
     * @return the species of the animal
     */
    public String getSpecies() {
        return species;
    }

    /**
     * Gets the age of the animal.
     *
     * @return the age of the animal
     */
    public int getAge() {
        return age;
    }

    /**
     * Gets the habitat of the animal.
     *
     * @return the habitat of the animal
     */
    public String getHabitat() {
        return habitat;
    }
}
