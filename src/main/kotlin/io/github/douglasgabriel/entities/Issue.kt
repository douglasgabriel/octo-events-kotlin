package io.github.douglasgabriel.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.Entity
import javax.persistence.Id

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
data class Issue(
    @Id
    val number: Long
)