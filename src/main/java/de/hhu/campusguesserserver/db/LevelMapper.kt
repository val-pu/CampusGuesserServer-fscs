package de.hhu.campusguesserserver.db

import de.hhu.campusguesserserver.domain.Level

object LevelMapper {

    fun fromLevelDTO(levelDTO: LevelDTO): Level {
        return Level(levelDTO.name, levelDTO.guesses, levelDTO.id)
    }

    fun toDTO(level: Level): LevelDTO {
        return LevelDTO(level.id, level.name).apply { guesses = level.guessRefs }
    }

}