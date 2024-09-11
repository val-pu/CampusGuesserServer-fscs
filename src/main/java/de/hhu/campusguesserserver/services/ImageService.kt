package de.hhu.campusguesserserver.services

import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.FileNotFoundException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption

// https://medium.com/@kkarththi15/saving-images-locally-in-a-spring-boot-web-application-01405a988bc7 (6.9.2024)
@Service
class ImageService {
    private val defaultFileEnding = ".jpg"
    private val defaultDirectory = "images"

    fun saveImage(
        fileName: String,
        imageFile: MultipartFile,
        imageDirectory: String = defaultDirectory,
        fileEnding: String = defaultFileEnding
    ) {

        val uploadPath = Path.of(imageDirectory)
        val filePath = uploadPath.resolve("$fileName$fileEnding")

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath)
        }

        Files.copy(imageFile.inputStream, filePath, StandardCopyOption.REPLACE_EXISTING)
    }

    fun getImage(
        imageName: String,
        imageDirectory: String = defaultDirectory,
        fileEnding: String = defaultFileEnding
    ): ByteArray {

        val uploadPath = Path.of(imageDirectory)
        val image = uploadPath.resolve("$imageName$fileEnding")

        if (!Files.exists(image)) {
            throw FileNotFoundException()
        }


        val imageBytes = Files.readAllBytes(image)
        return imageBytes
    }

    fun deleteImage(
        imageName: String,
        imageDirectory: String = defaultDirectory,
        fileEnding: String = defaultFileEnding
    ) {
        Files.delete(Path.of(imageDirectory, "$imageName$fileEnding"))
    }
}
