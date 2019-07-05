package ch.christianmenz.sch3ma;

import ch.christianmenz.sch3ma.model.Schema;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author Christian Menz
 */
public class SchemaGenerator {

    public static final String SCHEMA = "http://json-schema.org/draft-07/schema#";
    private final ObjectNode rootNode;
    private ObjectMapper objectMapper;
    private Schema schema;

    public SchemaGenerator(Schema schema) {
        this.schema = schema;
        objectMapper = new ObjectMapper();
        rootNode = objectMapper.createObjectNode();
        rootNode.put("$schema", SCHEMA);
        rootNode.put("$id", schema.getId());
        rootNode.put("title", schema.getTitle());
        rootNode.put("description", schema.getDescription());
        rootNode.put("type", schema.getType().value());

        ObjectNode propertiesNode = rootNode.putObject("properties");
        schema.getProperties().forEach(property -> {
            ObjectNode propertyNode = propertiesNode.putObject(property.getName());
            propertyNode.put("description", property.getName());
            propertyNode.put("type", property.getType().value());
        });
    }

    public String toJson() throws JsonProcessingException {
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
    }

    public ObjectNode toObjectNode() {
        return rootNode;
    }
}
