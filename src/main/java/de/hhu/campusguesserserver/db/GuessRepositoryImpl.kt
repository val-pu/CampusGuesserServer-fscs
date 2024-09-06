package de.hhu.campusguesserserver.db

import de.hhu.campusguesserserver.domain.Guess
import de.hhu.campusguesserserver.services.IGuessRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
open class GuessRepositoryImpl(var guessDAO: GuessDAO) : IGuessRepository {

    override fun findGuessById(uuid: UUID): Optional<Guess> {
        return guessDAO.findById(uuid).map(GuessMapper::fromGuessDTO)
    }

    override fun save(guess: Guess): Guess {

        val savedDTO = guessDAO.save(GuessMapper.toGuessDTO(guess))

        return GuessMapper.fromGuessDTO(savedDTO)
    }

    override fun findAll(): List<Guess> {
        return guessDAO.findAll().map(GuessMapper::fromGuessDTO)
    }
}