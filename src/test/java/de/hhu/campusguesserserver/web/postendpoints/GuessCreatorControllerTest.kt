package de.hhu.campusguesserserver.web.postendpoints

import de.hhu.campusguesserserver.services.GuessService
import de.hhu.campusguesserserver.services.ImageService
import de.hhu.campusguesserserver.web.forms.GuessForm
import org.mockito.kotlin.mock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.web.multipart.MultipartFile

@WebMvcTest
@ContextConfiguration(classes = [GuessCreatorController::class])
class GuessCreatorControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var imageService: ImageService

    @MockBean
    lateinit var guessService: GuessService

    val form = GuessForm(mock<MultipartFile> { }, 42.0, 4.2)

    fun postRequestWithFormField(): MockHttpServletRequestBuilder {
        return post("/submitGuess")
            .param("image", form.image.toString())
            .param("longitude", form.longitude.toString())
            .param("latitude", form.latitude.toString())
    }

    /*@Test
    @DisplayName("POST zu /submit mit richtigen Parametern liefert 200 OK")
    fun test_1() {
        mockMvc.perform(postRequestWithFormField()).
                andExpect(status().isOk)
    } FAIL*/
}