package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for mapping a Java field to a field in JSON format.
 * The specified value represents the name of the field in the JSON structure.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface JsonField {

    /**
     * Specifies the field name in the JSON format.
     *
     * @return the name of the JSON field as a string
     */
    String value();
}
