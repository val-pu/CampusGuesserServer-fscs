package de.hhu.campusguesserserver.db

import de.hhu.campusguesserserver.domain.Guess
import de.hhu.campusguesserserver.domain.Level

object GuessMapper {

    fun fromGuessDTO(guessDTO: GuessDTO): Guess {
        return Guess(guessDTO.latitude,guessDTO.longtitude,guessDTO.imgId)
    }

}