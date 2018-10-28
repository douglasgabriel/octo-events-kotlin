package io.github.douglasgabriel
import io.github.douglasgabriel.api.Api
import io.github.douglasgabriel.entities.Event
import io.github.douglasgabriel.repositories.EventsRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.SpringApplication

@SpringBootApplication
class OctoEventsApplication

fun main(args: Array<String>) {

    with(SpringApplication.run(OctoEventsApplication::class.java, *args)) {
        getBean(Api::class.java) // init API
    }

}
