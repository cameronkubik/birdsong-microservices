package application;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarketingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/marketing")
    public WebContent serveContent(@RequestParam(value="content", defaultValue="e404") String name) {
        return new WebContent(counter.incrementAndGet(),
                            String.format(template, name));
    }
}