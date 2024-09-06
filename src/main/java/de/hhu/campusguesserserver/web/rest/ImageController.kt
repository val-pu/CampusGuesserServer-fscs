package de.hhu.campusguesserserver.web.rest

import de.hhu.campusguesserserver.services.ImageService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.io.FileNotFoundException

@RestController
class ImageController(
    private val imageService: ImageService
) {

    @GetMapping(
        "image/{uuid}",
        produces = [MediaType.IMAGE_JPEG_VALUE]
    )
    fun getImageForId(@PathVariable uuid: String): ByteArray? {
        return imageService.getImage(uuid)
    }


    @ExceptionHandler(FileNotFoundException::class)
    fun notFound(): ResponseEntity<String> {
        return ResponseEntity("Bild net gefunden sry", HttpStatus.NOT_FOUND)
    }


}