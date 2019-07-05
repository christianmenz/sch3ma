package ch.christianmenz.sch3ma.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Christian Menz
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Schema {
    String title();

    String id();

    String description();
}
