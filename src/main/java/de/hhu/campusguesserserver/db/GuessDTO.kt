package de.hhu.campusguesserserver.db

import org.springframework.data.annotation.Id
import java.util.*

class GuessDTO(@Id var id: UUID?, val longtitude: Double, val latitude: Double, val imgId: String)