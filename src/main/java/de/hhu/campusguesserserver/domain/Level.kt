package de.hhu.campusguesserserver.domain

import java.util.*

data class Level(val name: String, val guessRefs: List<UUID>, var id: UUID? = null)