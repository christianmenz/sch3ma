package ch.christianmenz.sch3ma.test;

import ch.christianmenz.sch3ma.SchemaGenerator;
import ch.christianmenz.sch3ma.model.Schema;
import com.fasterxml.jackson.core.JsonProcessingException;

public class Main {

    public static void main(String[] args) throws JsonProcessingException {
        // some resource, with some handy annotations
        Test test = new Test();

        // easily create a schema
        Schema schema = Schema.of(test);

        // edit the schema (e.g. add & manipulate the initial schema
        // e.g. add options based on the context, remove stuff
        //Property property = schema.getProperty("");

        // use toJson to test, but you can also just add the
        // node to the result (e.g. HAL-Forms, Affordances)
        SchemaGenerator schemaGenerator = new SchemaGenerator(schema);
        System.out.println(schemaGenerator.toJson());
    }
}
