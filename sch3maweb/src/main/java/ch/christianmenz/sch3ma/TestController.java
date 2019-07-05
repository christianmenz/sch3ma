package ch.christianmenz.sch3ma;

import ch.christianmenz.sch3ma.model.Schema;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author Christian Menz
 */
@RestController
@RequestMapping(path = "/test")
public class TestController {

    @GetMapping
    public Mono<Proposal> get() {
        Proposal proposal = new Proposal();
        proposal.setName("Proposal Number 1");
        proposal.setModeOfContact("xyz");
        proposal.setOrders(5);

        Schema schema = Schema.of(proposal);
        proposal.addTemplate("modofyProposal", schema);
        proposal.addTemplate("submit", schema);

        return Mono.just(proposal);
    }

}
