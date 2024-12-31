package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * The {@code SerializedType} annotation is used to specify the name of the type (class) when serializing an object.
 * This annotation can be applied to a class to assign it a custom name during serialization
 * to formats like JSON or XML.
 *
 * <p>It is mainly used in reflection-based serialization to define how the type of an object is represented
 * in the serialized output.</p>
 *
 * <p>For example, this annotation allows the class to be represented by a different name in the serialized
 * format, which can be useful when the class name doesn't match the desired format or when a more descriptive name is needed.</p>
 *
 * @see java.lang.annotation.Retention
 * @see java.lang.annotation.RetentionPolicy
 * @see java.lang.annotation.ElementType
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SerializedType {

    /**
     * The name to be assigned to the annotated type (class) during serialization.
     * This name will be used in the serialized format, such as JSON or XML.
     *
     * @return the custom name for the type
     */
    String name();
}
