package de.hhu.campusguesserserver.services

import de.hhu.campusguesserserver.domain.Guess
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service
import java.util.*
import kotlin.jvm.optionals.getOrElse

@Service
class GuessService(val guessRepository: IGuessRepository) {
    fun getGuessById(uuid: UUID): Guess {
        return guessRepository.findGuessById(uuid).getOrElse {
            throw NotFoundException()
        }
    }

}