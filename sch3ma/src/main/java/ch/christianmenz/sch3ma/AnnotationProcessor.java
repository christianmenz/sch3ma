package ch.christianmenz.sch3ma;

import ch.christianmenz.sch3ma.annotation.Property;
import ch.christianmenz.sch3ma.model.Schema;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Christian Menz
 */
public class AnnotationProcessor {
    public void process(Object o, Schema schema) {
        Class<?> aClass = o.getClass();
        processSchemaAnnotation(schema, aClass);
        processProperties(schema, aClass);
    }

    // TODO: handle recursion here?
    private void processProperties(Schema schema, Class<?> aClass) {
        Field[] fields = aClass.getDeclaredFields();
        Arrays.stream(fields).forEach(field -> {
            Property[] annotationsByType = field.getAnnotationsByType(Property.class);
            if (annotationsByType.length == 1   ) {
                Property property = annotationsByType[0];
                ch.christianmenz.sch3ma.model.Property newProperty = new ch.christianmenz.sch3ma.model.Property();
                newProperty.setDescription(property.description());
                newProperty.setName(property.name());
                newProperty.setType(property.type());
                schema.addProperty(newProperty);
            }
        });
    }

    private void processSchemaAnnotation(Schema schema, Class<?> aClass) {
        ch.christianmenz.sch3ma.annotation.Schema[] schemaAnnotations = aClass.getAnnotationsByType(ch.christianmenz.sch3ma.annotation.Schema.class);
        if (schemaAnnotations.length == 1) {
            String id = schemaAnnotations[0].id();
            String title = schemaAnnotations[0].title();
            String description = schemaAnnotations[0].description();

            schema.setTitle(title);
            schema.setId(id);
            schema.setDescription(description);
        } else {
            throw new IllegalArgumentException("The class must have exactly one schema annotation");
        }
    }
}
