package io.github.douglasgabriel.services

import io.github.douglasgabriel.entities.Event

/**
 * Defines methods to manage [Event]s entities.
 */
interface EventsService : CrudService<Event>{

    /**
     * Returns all events with the issueNumber
     *
     * @param [issueNumber] the number of the issue
     * @return a [Iterable<Event>] containing all events found
     */
    fun getByIssueNumber(issueNumber : Long) : Iterable<Event>

}