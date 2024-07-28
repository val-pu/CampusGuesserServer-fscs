package de.hhu.campusguesserserver.services

import de.hhu.campusguesserserver.domain.Level
import org.springframework.stereotype.Service
import java.util.*

@Service
class LevelService {

    fun getLevel(levelId: Int): Level {
        return Level("Dummy", LinkedList())
    }


}