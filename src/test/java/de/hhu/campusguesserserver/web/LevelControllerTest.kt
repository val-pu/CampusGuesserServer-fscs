package de.hhu.campusguesserserver.web

import de.hhu.campusguesserserver.LevelMother
import de.hhu.campusguesserserver.services.LevelService
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.util.*

@WebMvcTest
class LevelControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var levelService: LevelService

    @Test
    @DisplayName("""
        Wenn: Endpoint level mit richtigen Parametern aufgerufen. Dann: 2xx Code
        """)
    fun testLevelController() {
        val levelUUID = UUID.randomUUID()
        whenever(levelService.getLevelById(levelUUID)).thenReturn(LevelMother.emptyLevel())
        mockMvc.perform(get("/level")
            .param("levelUUID", levelUUID.toString())
        ).andExpect(status().is2xxSuccessful)
    }

    @Test
    @DisplayName("""
        Wenn: Endpoint level mit richtigen Parametern aufgerufen wurde und level nicht existiert. Dann: Statuscode: NOT FOUND
        """)
    fun testErrorNotFound() {
        val levelUUID = UUID.randomUUID()
        whenever(levelService.getLevelById(levelUUID)).thenThrow(NotFoundException::class.java)
        mockMvc.perform(get("/level")
            .param("levelUUID", levelUUID.toString())
        ).andExpect(status().isNotFound)
    }


}