package de.hhu.campusguesserserver.services

import de.hhu.campusguesserserver.domain.Level
import org.springframework.stereotype.Service

@Service
class LevelService {

    fun getLevel(levelId: Int): Level {
        return Level("Dummy")
    }


}