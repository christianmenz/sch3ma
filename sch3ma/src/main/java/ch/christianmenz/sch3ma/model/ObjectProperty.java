package ch.christianmenz.sch3ma.model;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Christian Menz
 */
public class ObjectProperty extends Property {

    private List<Property> properties = new LinkedList<Property>();

    public ObjectProperty() {
        setType(Type.OBJECT);
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public void addProperty(Property property) {
        this.properties.add(property);
    }
}
