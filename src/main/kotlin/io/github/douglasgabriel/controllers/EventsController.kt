package io.github.douglasgabriel.controllers

import io.github.douglasgabriel.services.EventsService
import io.javalin.Context
import org.springframework.stereotype.Component
import javax.inject.Inject
import io.github.douglasgabriel.entities.Event
import io.github.douglasgabriel.extensions.deserialize
import org.eclipse.jetty.http.HttpStatus

@Component
class EventsController @Inject constructor(
    eventsService : EventsService
){

    val post: (ctx : Context) -> Unit = {
        val event : Event? = it.formParam("payload")?.deserialize()

        if (event is Event){
            it
                .json(eventsService.save(event))
                .status(HttpStatus.CREATED_201)
        } else {
            it.status(HttpStatus.BAD_REQUEST_400)
        }

    }

}
