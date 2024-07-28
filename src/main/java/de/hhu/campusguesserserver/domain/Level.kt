package de.hhu.campusguesserserver.domain

import java.util.*

class Level(val name: String, val guesses: List<Guess>, val id: UUID? = null) {
}