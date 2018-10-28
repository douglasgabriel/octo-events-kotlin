package io.github.douglasgabriel.services.implementations

import io.github.douglasgabriel.entities.Event
import io.github.douglasgabriel.repositories.EventsRepository
import io.github.douglasgabriel.services.EventsService
import io.github.douglasgabriel.services.IssuesService
import org.springframework.stereotype.Service
import javax.inject.Inject

/**
 * Provides implementation to methods defined in
 * [EventsService]
 */
@Service
class EventsServiceImpl @Inject constructor(
    private val eventsRepository: EventsRepository,
    private val issuesService: IssuesService
) : EventsService {

    /**
     * Saves an [Event].
     *  Also request the save of the associated [io.github.douglasgabriel.entities.Issue]
     *
     * @see [EventsService.save]
     * @see [IssuesService.save]
     */
    override fun save(event : Event) : Event {
        event.issue?.let { issuesService.save(it) }

        return eventsRepository.save(event)
    }

    override fun getByIssueNumber(issueNumber: Long) = eventsRepository.findByIssueNumber(issueNumber)

}