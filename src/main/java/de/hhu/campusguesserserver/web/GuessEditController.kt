package de.hhu.campusguesserserver.web

import de.hhu.campusguesserserver.services.GuessService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class GuessEditController(
    private val guessService: GuessService,
    service: GuessService
) {

    @GetMapping("guesses")
    fun viewGuesses(model: Model): String {
        model.addAttribute("guesses",guessService.getAllGuesses())
        return "guesses"
    }


}