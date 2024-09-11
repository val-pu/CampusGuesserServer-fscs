package de.hhu.campusguesserserver.web

import de.hhu.campusguesserserver.domain.Guess
import java.util.*

class GuessBuilder {

    private var longitude: Double = 10.0
    private var latitude: Double = 11.0
    private var id: UUID? = UUID.randomUUID()

    fun withUUID(uuid: UUID?): GuessBuilder {
        this.id = uuid
        return this
    }

    fun withLatitude(latitude: Double): GuessBuilder {
        this.latitude = latitude
        return this
    }

    fun withLongitude(latitude: Double): GuessBuilder {
        this.longitude = latitude
        return this
    }

    fun build(): Guess {
        return Guess(latitude, longitude, id)
    }
}