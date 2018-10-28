package io.github.douglasgabriel.repositories

import org.springframework.data.repository.CrudRepository
import io.github.douglasgabriel.entities.Event
import org.springframework.stereotype.Component

interface EventsRepository : CrudRepository<Event, Long> {

    fun findByIssueNumber(issueNumber : Long) : Iterable<Event>

}