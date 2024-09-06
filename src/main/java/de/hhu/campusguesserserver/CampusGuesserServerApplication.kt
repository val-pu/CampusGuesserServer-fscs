package de.hhu.campusguesserserver

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

fun main(args: Array<String>) {
    SpringApplication.run(CampusGuesserServerApplication::class.java, *args)
}


@SpringBootApplication
open class CampusGuesserServerApplication {}