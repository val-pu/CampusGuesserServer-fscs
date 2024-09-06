package de.hhu.campusguesserserver.db

import de.hhu.campusguesserserver.domain.Level
import de.hhu.campusguesserserver.services.ILevelRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
open class LevelRepositoryImpl(val levelDAO: LevelDAO? = null) : ILevelRepository {

    override fun findGuessByUuid(uuid: UUID): Optional<Level> {
        val foundDTO = levelDAO!!.findById(uuid)

        if (foundDTO.isEmpty) {
            return Optional.empty()
        }

        return Optional.of(
            LevelMapper.fromLevelDTO(foundDTO.get())
        )
    }

    override fun findAllLevels(): Set<Level> {
        return levelDAO!!.findAll()
            .map(LevelMapper::fromLevelDTO)
            .toSet()
    }

    override fun save(level: Level): Level {
        return LevelMapper.fromLevelDTO(levelDAO!!.save(LevelMapper.toDTO(level)))
    }
}