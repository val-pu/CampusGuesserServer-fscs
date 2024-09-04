package de.hhu.campusguesserserver.services

import de.hhu.campusguesserserver.domain.Level
import java.util.Optional
import java.util.UUID

interface ILevelRepository {
    fun findGuessByUuid(uuid: UUID): Optional<Level>
    fun findAllLevels(): Set<Level>
}