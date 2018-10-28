package io.github.douglasgabriel.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp
import javax.persistence.*

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
data class Event (
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	val id: Long,

	val action: String,

	@ManyToOne
	@get:JsonIgnore
	val issue: Issue?,

	@field:CreationTimestamp
	val createdAt: Timestamp?,

	@field:UpdateTimestamp
	val updatedAt: Timestamp?
)