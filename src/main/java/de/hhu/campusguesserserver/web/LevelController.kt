package de.hhu.campusguesserserver.web

import de.hhu.campusguesserserver.domain.Guess
import de.hhu.campusguesserserver.domain.Level
import de.hhu.campusguesserserver.services.GuessService
import de.hhu.campusguesserserver.services.LevelService
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class LevelController(
    private val levelService: LevelService,
    private val guessService: GuessService,
    service: GuessService
) {

    @GetMapping("level/all", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllLevel(): Level {
        return levelService.getAllLevels()
    }

    @GetMapping("level", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getLevel(levelUUID: UUID): Level {
        return levelService.getLevelById(levelUUID)
    }

    @GetMapping("guess", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getGuess(guessUUID: UUID): Guess {
        return guessService.getGuessById(guessUUID)
    }

    @PostMapping("submitLevel", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun test(): Level {
        val level = Level("bla", LinkedList(), null)
        return levelService.save(level)
    }

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND, reason = "No level/guess with the defined id found.")
    fun handler(): String {
        return ""
    }
}