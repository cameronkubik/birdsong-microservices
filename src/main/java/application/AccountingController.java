package application;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/accounting")
    public AccountingEvent handleEvent(@RequestParam(value="event", defaultValue="e404") String name) {
        return new AccountingEvent(counter.incrementAndGet(),
                            String.format(template, name));
    }
}