package alejandro.lajusticia.reactive.producer;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.Stream;

@Component
public class SomeObjectProducer {

    public Flux<String> someObject() {
        return Flux.fromStream(Stream.generate(() -> "Hello world! @ " + Instant.now()))
                .delayElements(Duration.ofSeconds(1));
    }

}
