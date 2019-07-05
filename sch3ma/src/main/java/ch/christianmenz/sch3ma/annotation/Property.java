package ch.christianmenz.sch3ma.annotation;

import ch.christianmenz.sch3ma.model.Type;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Christian Menz
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Property {
    String name();

    String description() default "";

    Type type();

    boolean required() default false;
}
