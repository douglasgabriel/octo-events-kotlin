package io.github.douglasgabriel.controllers

import io.github.douglasgabriel.api.Api
import io.github.douglasgabriel.entities.Event
import io.github.douglasgabriel.entities.Issue
import io.github.douglasgabriel.extensions.deserialize
import io.github.douglasgabriel.services.EventsService
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.sql.Timestamp
import java.time.Instant
import javax.inject.Inject
import khttp.get
import org.eclipse.jetty.http.HttpStatus
import org.junit.Assert

@RunWith(SpringRunner::class)
@SpringBootTest
class IssuesControllerTest {

    @Inject
    private lateinit var eventsService : EventsService
    @Inject
    private lateinit var api: Api
    private val url by lazy {
        "http://localhost:${api.port}"
    }

    @Before
    fun setup() {
        eventsService.save(
                Event(
                        id = 1,
                        issue = Issue(number = 1),
                        updatedAt = Timestamp.from(Instant.now()),
                        createdAt = Timestamp.from(Instant.now()),
                        action = "opened"
                )
        )
    }

    @Test
    fun testGetIssueEvents() {
        val response = get(url = "$url/issues/1/events")

        Assert.assertEquals(response.statusCode, HttpStatus.OK_200)

        val event : Event? = response.jsonArray.get(0).toString().deserialize()

        Assert.assertNull(event?.issue)
        Assert.assertEquals(event?.id, 1L)
    }

}