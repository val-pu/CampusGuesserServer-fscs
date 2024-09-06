package de.hhu.campusguesserserver.db

import de.hhu.campusguesserserver.LevelMother
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LevelMapperTest {
    @Test
    @DisplayName("Mapping to DTO and then from DTO returns same level as inputed")
    fun test_1() {
        val inputLevel = LevelMother.levelWithTwoRandomGuessIds()
        val output = LevelMapper.fromLevelDTO(LevelMapper.toDTO(inputLevel))
        assertThat(output).isEqualTo(inputLevel)
    }

}