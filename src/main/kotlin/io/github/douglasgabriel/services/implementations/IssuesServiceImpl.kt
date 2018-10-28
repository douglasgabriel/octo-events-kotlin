package io.github.douglasgabriel.services.implementations

import io.github.douglasgabriel.entities.Issue
import io.github.douglasgabriel.repositories.IssuesRepository
import io.github.douglasgabriel.services.IssuesService
import org.springframework.stereotype.Service
import javax.inject.Inject

/**
 * Provides implementation to methods defined in
 * [IssuesService]
 */
@Service
class IssuesServiceImpl @Inject constructor(
    private val issuesRepository: IssuesRepository
) : IssuesService {

    /**
     * Saves an [Issue] if its number doesn't exist in database
     * @see [IssuesService.save]
     */
    override fun save(issue: Issue): Issue {
        return issuesRepository
                .findById(issue.number)
                .orElseGet { issuesRepository.save(issue) }
    }
}