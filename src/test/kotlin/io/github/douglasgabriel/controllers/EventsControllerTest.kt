package io.github.douglasgabriel.controllers

import io.github.douglasgabriel.api.Api
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import khttp.post
import org.eclipse.jetty.http.HttpStatus
import org.junit.Assert
import javax.inject.Inject

@RunWith(SpringRunner::class)
@SpringBootTest
class EventsControllerTest {

    @Inject
    private lateinit var api: Api
    private val url by lazy {
        "http://localhost:${api.port}"
    }

    @Test
    fun testPostValidEvent() {
        val githubWebhook = """
            {
              "action": "opened",
              "issue": {
                "number": 1347
              }
            }
        """.trimIndent()

        val payload = mapOf("payload" to githubWebhook)

        val response = post("$url/events", data = payload)

        Assert.assertEquals(response.statusCode, HttpStatus.CREATED_201)
    }

    @Test
    fun testPostInvalidEvent() {
        val payload = mapOf("payload" to null)

        val response = post("$url/events", data = payload)

        Assert.assertEquals(response.statusCode, HttpStatus.BAD_REQUEST_400)
    }

    @Test
    fun testPostMissingPayload() {
        val response = post("$url/events", data = null)

        Assert.assertEquals(response.statusCode, HttpStatus.BAD_REQUEST_400)
    }
}