package de.hhu.campusguesserserver.web.forms

import org.springframework.web.multipart.MultipartFile

data class GuessForm(val image: MultipartFile, val latitude: Double, val longitude: Double)