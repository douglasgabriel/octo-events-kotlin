package io.github.douglasgabriel.extensions

import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.lang.IllegalStateException

/**
 * Converts a JSON string into a [T] instance
 *
 * @return [T] instance based on JSON content
 * @return null if the JSON doesn't correspond to [T]
 */
inline fun <reified T : Any> String.deserialize(): T? {
    return try {
        jacksonObjectMapper().readValue(this)
    } catch( ex : Exception ) {
        when(ex){
            is JsonParseException,
            is IllegalStateException -> null
            else -> throw ex
        }
    }
}