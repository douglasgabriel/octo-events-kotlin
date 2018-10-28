package io.github.douglasgabriel.controllers

import io.github.douglasgabriel.services.EventsService
import io.javalin.Context
import org.eclipse.jetty.http.HttpStatus
import org.springframework.stereotype.Component
import javax.inject.Inject

@Component
class IssuesController @Inject constructor(
    eventsService: EventsService
){

    val getEvents: (ctx : Context) -> Unit = {
        val issueNumber = it.pathParam("id").toLong()
        val result = eventsService.getByIssueNumber(issueNumber)

        if (result.count() > 0) it.json(result)
        else it.status(HttpStatus.NOT_FOUND_404)
    }

}
