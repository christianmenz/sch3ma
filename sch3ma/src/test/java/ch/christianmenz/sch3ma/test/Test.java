package ch.christianmenz.sch3ma.test;

import ch.christianmenz.sch3ma.annotation.Property;
import ch.christianmenz.sch3ma.annotation.Schema;
import ch.christianmenz.sch3ma.model.Type;

@Schema(title = "Test Title", id = "test-id",description = "A test description")
public class Test {

    @Property(
            name = "name",
            description = "Some description",
            type = Type.STRING
    )
    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}