package alejandro.lajusticia.reactive.controller;

import alejandro.lajusticia.reactive.producer.SomeObjectProducer;
import org.reactivestreams.Publisher;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class SomeReactiveController {

    private final SomeObjectProducer producer;

    public SomeReactiveController(final SomeObjectProducer someObjectProducer) {
        producer = someObjectProducer;
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Publisher<String> getAll() {
        return producer.someObject();
    }

}
