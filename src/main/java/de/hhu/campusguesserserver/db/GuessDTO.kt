package de.hhu.campusguesserserver.db

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("guesses")
class GuessDTO(@Id var id: UUID?, val longitude: Double, val latitude: Double)