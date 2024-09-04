package de.hhu.campusguesserserver.db

import org.springframework.data.repository.CrudRepository
import java.util.*

interface GuessDAO: CrudRepository<GuessDTO, UUID> {
    override fun findById(uuid: UUID): Optional<GuessDTO>
}