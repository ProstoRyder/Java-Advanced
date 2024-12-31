package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for mapping a Java field to a field in XML format.
 * The specified value represents the name of the field in the XML structure.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface XmlField {

    /**
     * Specifies the field name in the XML format.
     *
     * @return the name of the XML field as a string
     */
    String value();
}
