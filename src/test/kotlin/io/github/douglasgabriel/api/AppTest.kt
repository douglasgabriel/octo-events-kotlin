package io.github.douglasgabriel.api

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import javax.inject.Inject

import khttp.get
import org.eclipse.jetty.http.HttpStatus
import org.junit.Assert

@RunWith(SpringRunner::class)
@SpringBootTest
class AppTest {

    private val url = "http://localhost:3000"

    @Test
    fun testApiIsUp() {
        Assert.assertEquals(get(url = url).statusCode, HttpStatus.NOT_FOUND_404)
    }

}
