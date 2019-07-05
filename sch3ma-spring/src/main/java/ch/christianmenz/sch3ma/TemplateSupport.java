package ch.christianmenz.sch3ma;

import ch.christianmenz.sch3ma.model.Schema;
import ch.christianmenz.sch3ma.model.Template;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author Christian Menz
 */
public class TemplateSupport {

    @JsonUnwrapped
    private Template template = new Template();

    public Template getTemplate() {
        return template;
    }

    public void addTemplate(String name, Schema schema) {
        SchemaGenerator schemaGenerator = new SchemaGenerator(schema);
        ObjectNode objectNode = schemaGenerator.toObjectNode();
        this.template.addTemplate(name, objectNode);
    }
}
