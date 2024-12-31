package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * The {@code SerializedField} annotation is used to specify the name of a field when serializing an object.
 * This annotation can be applied to fields to map them to a custom name during serialization
 * to formats like JSON or XML.
 *
 * <p>It is primarily used in reflection-based serialization to control how a field is represented in the serialized output.</p>
 *
 * <p>For instance, this annotation allows you to define a different name for a field in the serialized format,
 * which might differ from the field's name in the Java class.</p>
 *
 * @see java.lang.annotation.Retention
 * @see java.lang.annotation.RetentionPolicy
 * @see java.lang.annotation.ElementType
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SerializedField {

    /**
     * The name to be assigned to the annotated field during serialization.
     * This name will be used in the serialized format, such as JSON or XML.
     *
     * @return the custom name for the field
     */
    String name();
}
