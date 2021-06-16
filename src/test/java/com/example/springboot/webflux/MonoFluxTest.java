package com.example.springboot.webflux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void testMono() {
        Mono<?> monoString = Mono.just("spring-reactive").then(Mono.error(new RuntimeException("Exception.."))).log();
        monoString.subscribe(System.out::println, (e) -> System.out.println(e.getMessage()));
    }

    @Test
    public void testFlux() {
         // this is publisher with events
        Flux<String> stringFlux = Flux.just("spring", "springboot", "hibernate", "microservice")
                .concatWithValues("AWS")
                .concatWith(Flux.error(new RuntimeException("Exception..")))
                .concatWithValues("Cloud")
                .log();
        //subscriber
        stringFlux.subscribe(System.out::println, (e) -> System.out.println(e.getMessage()));
    }
}


