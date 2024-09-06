package de.hhu.campusguesserserver.web

import de.hhu.campusguesserserver.domain.Guess
import de.hhu.campusguesserserver.services.GuessService
import de.hhu.campusguesserserver.services.ImageService
import de.hhu.campusguesserserver.web.forms.GuessForm
import org.springframework.stereotype.Controller
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
open class IndexController(
    val imageService: ImageService,
    val guessService: GuessService
) {
    @GetMapping("/")
    fun index(): String {
        return "index"
    }

    @PostMapping("submitGuess")
    @Transactional
    open fun submitGuess(form: GuessForm): String {

        val saved = guessService.saveGuess(Guess(form.latitude, form.longitude))
        imageService.saveImage(saved.id!!.toString(), form.image)

        return "index"
    }

}