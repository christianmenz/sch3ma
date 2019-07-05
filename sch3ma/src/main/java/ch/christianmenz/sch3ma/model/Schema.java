package ch.christianmenz.sch3ma.model;

import ch.christianmenz.sch3ma.AnnotationProcessor;

/**
 * A schema instance.
 *
 * @author Christian Menz
 */
public class Schema extends ObjectProperty {
    private String id;
    private String title;

    public Schema() {
    }

    public static Schema of(Object object) {
        Schema schema = new Schema();
        AnnotationProcessor processor = new AnnotationProcessor();
        processor.process(object, schema);
        return schema;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    // TODO: find another way to get rid of the name property.
    // e.g. split the class hierarchies..
}
