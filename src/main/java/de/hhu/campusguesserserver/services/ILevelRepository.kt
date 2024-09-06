package de.hhu.campusguesserserver.services

import de.hhu.campusguesserserver.domain.Level
import java.util.*

interface ILevelRepository {
    fun findGuessByUuid(uuid: UUID): Optional<Level>
    fun findAllLevels(): Set<Level>
    fun save(level: Level): Level
}