package de.hhu.campusguesserserver.web

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest
class LevelControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    @DisplayName("""
        Wenn: Endpoint level mit richtigen Parametern aufgerufen. Dann: 2xx Code
        """)
    fun testLevelController() {
        mockMvc.perform(get("/level")
            .param("levelId", "1")
        ).andExpect(status().is2xxSuccessful)
    }


}