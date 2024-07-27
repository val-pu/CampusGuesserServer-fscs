package de.hhu.campusguesserserver.web

import de.hhu.campusguesserserver.domain.Level
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LevelController {
    @GetMapping("level", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getLevel(levelId: Int): Level {
        return Level("da")
    }
}