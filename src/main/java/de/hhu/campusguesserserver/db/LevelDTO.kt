package de.hhu.campusguesserserver.db

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("levels")
class LevelDTO(
    @Id
    var id: UUID?,
    val name: String,
) {
    var guesses: List<UUID> = LinkedList()
}