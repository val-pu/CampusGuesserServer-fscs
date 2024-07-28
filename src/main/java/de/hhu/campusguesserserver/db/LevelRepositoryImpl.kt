package de.hhu.campusguesserserver.db

import de.hhu.campusguesserserver.domain.Level
import de.hhu.campusguesserserver.services.ILevelRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class LevelRepositoryImpl(val levelDAO: LevelDAO) : ILevelRepository {

    override fun findLevelByUuid(uuid: UUID): Optional<Level> {
        val foundDTO = levelDAO.findByUuid(uuid)

        if (foundDTO.isEmpty) {
            return Optional.empty()
        }

        return Optional.of(
            LevelMapper.fromLevelDTO(foundDTO.get())
        )
    }

    override fun findAllLevels(): Set<Level> {
        return levelDAO.findAll()
            .map(LevelMapper::fromLevelDTO)
            .toSet()
    }
}