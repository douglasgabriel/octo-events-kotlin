package io.github.douglasgabriel.services

/**
 * Defines CRUD methods for an entity
 *
 * @param T the entity type
 */
interface CrudService<T> {

    /**
     * Saves an entity
     *
     * @param [entity] entity to be saved
     * @return the saved entity
     */
    fun save(entity : T) : T

}