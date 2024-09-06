package de.hhu.campusguesserserver.services

import org.apache.commons.io.IOUtils
import org.springframework.stereotype.Service
import org.springframework.util.ResourceUtils
import java.util.*

@Service
class ImageService {
    fun getImageForGuessUUID(uuid: UUID): ByteArray? {
        return IOUtils.toByteArray(
            ResourceUtils.getFile("./images/$uuid").inputStream()
        )
    }

    fun deleteImageForGuessUUID(uuid: UUID) {
        ResourceUtils.getFile("./images/$uuid").delete()
    }
}
