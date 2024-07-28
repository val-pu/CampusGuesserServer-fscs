package de.hhu.campusguesserserver.db

import de.hhu.campusguesserserver.domain.Guess
import de.hhu.campusguesserserver.domain.Level

object LevelMapper {

    fun fromLevelDTO(levelDTO: LevelDTO): Level {

        val guesses = levelDTO.guesses.map {
            Guess(it.latitude, it.longtitude, it.imgId)
        }

        return Level(levelDTO.name, guesses, levelDTO.id)
    }

}