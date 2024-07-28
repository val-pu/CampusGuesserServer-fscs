package de.hhu.campusguesserserver.db

import org.springframework.data.repository.CrudRepository
import java.util.*

interface LevelDAO: CrudRepository<LevelDTO, UUID> {
    override fun findAll(): Set<LevelDTO>

    fun findByUuid(uuid: UUID): Optional<LevelDTO>

    fun save(level: LevelDTO)
}