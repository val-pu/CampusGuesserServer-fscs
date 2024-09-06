package de.hhu.campusguesserserver

import de.hhu.campusguesserserver.db.LevelDTO
import de.hhu.campusguesserserver.domain.Level
import java.util.*

object LevelMother {

    fun emptyLevel(): Level {
        return Level("Test1", LinkedList(), UUID.randomUUID())
    }

    fun levelWithTwoRandomGuessIds(): Level {
        return Level("Test1", listOf(UUID.randomUUID(),UUID.randomUUID()), null)
    }

    fun emptyLevelDTO(): LevelDTO {
        return LevelDTO(UUID.randomUUID(),"Test1")
    }

}