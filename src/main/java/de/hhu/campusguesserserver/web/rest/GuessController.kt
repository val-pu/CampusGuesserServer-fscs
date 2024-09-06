package de.hhu.campusguesserserver.web.rest

import de.hhu.campusguesserserver.domain.Guess
import de.hhu.campusguesserserver.services.GuessService
import de.hhu.campusguesserserver.services.ImageService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class GuessController(
    private val guessService: GuessService,
    private val imageService: ImageService
) {

    @GetMapping("guess", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getGuess(guessUUID: UUID): Guess {
        return guessService.getGuessById(guessUUID)
    }

    @GetMapping("guess/all", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllGuesses(): List<Guess> {
        return guessService.getAllGuesses()
    }

}