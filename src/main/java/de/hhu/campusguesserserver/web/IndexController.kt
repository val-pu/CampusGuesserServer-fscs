package de.hhu.campusguesserserver.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
open class IndexController {
    @GetMapping("/")
    fun index(): String {
        return "index"
    }
}