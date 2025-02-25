package de.hhu.campusguesserserver.services

import de.hhu.campusguesserserver.domain.Guess
import java.util.*

interface IGuessRepository {
    fun findGuessById(uuid: UUID): Optional<Guess>
    fun save(guess: Guess): Guess
    fun findAll(): List<Guess>
}