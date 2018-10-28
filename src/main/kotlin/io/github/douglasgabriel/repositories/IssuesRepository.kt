package io.github.douglasgabriel.repositories

import io.github.douglasgabriel.entities.Issue
import org.springframework.data.repository.CrudRepository

interface IssuesRepository : CrudRepository<Issue, Long>