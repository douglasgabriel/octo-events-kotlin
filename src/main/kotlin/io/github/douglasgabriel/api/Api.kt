package io.github.douglasgabriel.api

import io.github.douglasgabriel.controllers.EventsController
import io.github.douglasgabriel.controllers.IssuesController
import io.javalin.Javalin
import org.springframework.core.env.Environment
import org.springframework.stereotype.Component
import javax.inject.Inject

/**
 * Represents the application API.
 *  Contains Web entry point definitions.
 */
@Component
class Api @Inject constructor(
    eventsController: EventsController,
    issuesController: IssuesController,
    environment: Environment
) : Javalin() {

    val port by lazy {
        environment.getProperty("api.port")!!.toInt()
    }

    init {
        with(create().start(port)){
            get("/issues/:id/events", issuesController.getEvents)

            post("/events", eventsController.post)
        }
    }

}