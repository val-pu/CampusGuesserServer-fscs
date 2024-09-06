package de.hhu.campusguesserserver.db

import org.springframework.data.repository.CrudRepository
import java.util.*

interface GuessDAO: CrudRepository<GuessDTO, UUID> {
    fun save(guess: GuessDTO): GuessDTO
    override fun findById(uuid: UUID): Optional<GuessDTO>
}