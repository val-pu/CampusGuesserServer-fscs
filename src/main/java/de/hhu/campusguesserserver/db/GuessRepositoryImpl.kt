package de.hhu.campusguesserserver.db

import de.hhu.campusguesserserver.domain.Guess
import de.hhu.campusguesserserver.services.IGuessRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class GuessRepositoryImpl(val guessDAO: GuessDAO) : IGuessRepository {

    override fun findGuessById(uuid: UUID): Optional<Guess> {
        return guessDAO.findById(uuid).map(GuessMapper::fromGuessDTO)
    }
}