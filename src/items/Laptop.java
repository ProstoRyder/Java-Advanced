package items;

import annotations.JsonField;
import annotations.XmlField;

/**
 * Represents a Laptop with attributes for model, processor, and storage.
 * This class supports mapping of its fields for both JSON and XML serialization
 * using the {@link JsonField} and {@link XmlField} annotations.
 */
public class Laptop {

    /**
     * The model of the laptop.
     * Serialized as "model" in JSON and "Model" in XML.
     */
    @JsonField("model")
    @XmlField("Model")
    private String model;

    /**
     * The processor of the laptop.
     * Serialized as "processor" in JSON and "Processor" in XML.
     */
    @JsonField("processor")
    @XmlField("Processor")
    private String processor;

    /**
     * The storage capacity of the laptop.
     * Serialized as "year" in JSON and "Year" in XML.
     */
    @JsonField("year")
    @XmlField("Year")
    private String storage;

    /**
     * Constructs a new Laptop instance with the specified model, processor, and storage.
     *
     * @param model    the model of the laptop (e.g., "MacBook Pro")
     * @param processor the processor type of the laptop (e.g., "Intel Core i7")
     * @param storage  the storage capacity of the laptop (e.g., "512GB SSD")
     */
    public Laptop(String model, String processor, String storage) {
        this.model = model;
        this.processor = processor;
        this.storage = storage;
    }

    /**
     * Gets the model of the laptop.
     *
     * @return the model of the laptop
     */
    public String getModel() {
        return model;
    }

    /**
     * Gets the processor of the laptop.
     *
     * @return the processor of the laptop
     */
    public String getProcessor() {
        return processor;
    }

    /**
     * Gets the storage of the laptop.
     *
     * @return the storage of the laptop
     */
    public String getStorage() {
        return storage;
    }
}
