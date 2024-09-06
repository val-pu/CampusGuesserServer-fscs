package de.hhu.campusguesserserver.db

import de.hhu.campusguesserserver.domain.Guess

object GuessMapper {

    fun fromGuessDTO(guessDTO: GuessDTO): Guess {
        return Guess(guessDTO.latitude, guessDTO.longitude, guessDTO.id)
    }

    fun toGuessDTO(guess: Guess): GuessDTO {
        return GuessDTO(guess.id, guess.longitude, guess.latitude)
    }

}