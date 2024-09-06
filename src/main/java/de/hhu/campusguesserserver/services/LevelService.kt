package de.hhu.campusguesserserver.services

import de.hhu.campusguesserserver.domain.Level
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service
import java.util.*
import kotlin.jvm.optionals.getOrElse

@Service
class LevelService(
    val levelRepository: ILevelRepository
) {

    fun getLevelById(levelId: UUID): Level {
        return levelRepository.findGuessByUuid(levelId).getOrElse { throw NotFoundException() }
    }

    fun save(level: Level): Level {
        return levelRepository.save(level)
    }

    fun getAllLevels(): Level {
        TODO("Not yet implemented")
    }


}