package de.hhu.campusguesserserver.db

import org.springframework.data.annotation.Id
import java.util.*

class LevelDTO(
    @Id
    val id: UUID?,
    val name: String,
    val guesses: List<GuessDTO>
)