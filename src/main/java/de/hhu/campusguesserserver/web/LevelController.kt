package de.hhu.campusguesserserver.web

import de.hhu.campusguesserserver.domain.Guess
import de.hhu.campusguesserserver.domain.Level
import de.hhu.campusguesserserver.services.GuessService
import de.hhu.campusguesserserver.services.LevelService
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class LevelController(
    private val levelService: LevelService,
    private val guessService: GuessService,
    service: GuessService
) {

    @GetMapping("level", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getLevel(levelUUID: UUID): Level {
        return levelService.getLevelById(levelUUID)
    }

    @GetMapping("guess", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getGuess(guessUUID: UUID): Guess {
        return guessService.getGuessById(guessUUID)
    }

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND, reason = "No level/guess with the defined id found.")
    fun handler(): String {
        return ""
    }
}