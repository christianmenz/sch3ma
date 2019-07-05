package ch.christianmenz.sch3ma;

import ch.christianmenz.sch3ma.annotation.Property;
import ch.christianmenz.sch3ma.annotation.Schema;
import ch.christianmenz.sch3ma.model.Type;

/**
 * @author Christian Menz
 */
@Schema(id = "Proposal", title = "Proposal Title", description = "Just a test")
public class Proposal extends TemplateSupport {

    @Property(name = "name", description = "name of the proposal", type = Type.STRING)
    private String name;

    @Property(name = "orders", description = "number of orders", type = Type.NUMBER)
    private int orders;

    @Property(name = "modeOfContact", description = "the mode of contact", type = Type.STRING)
    private String modeOfContact;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }

    public String getModeOfContact() {
        return modeOfContact;
    }

    public void setModeOfContact(String modeOfContact) {
        this.modeOfContact = modeOfContact;
    }
}
