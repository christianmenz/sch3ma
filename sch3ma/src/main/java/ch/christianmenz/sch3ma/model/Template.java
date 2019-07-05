package ch.christianmenz.sch3ma.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.HashMap;
import java.util.Map;

/**
 * The template holds a map with named templates and the
 * corresponding schema.
 *
 * @author Christian Menz
 */
public class Template {

    @JsonProperty("templates")
    private Map<String, ObjectNode> templateMap = new HashMap<>();

    public Map<String, ObjectNode> getTemplateMap() {
        return templateMap;
    }

    public void setTemplateMap(Map<String, ObjectNode> templateMap) {
        this.templateMap = templateMap;
    }

    public void addTemplate(String name, ObjectNode schemaNode) {
        this.templateMap.put(name, schemaNode);
    }

}
