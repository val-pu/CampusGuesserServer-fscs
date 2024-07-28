package de.hhu.campusguesserserver.db

import java.util.UUID

class LevelDTO(
    val id: UUID,
    val name: String,
    val guesses: List<GuessDTO>
)