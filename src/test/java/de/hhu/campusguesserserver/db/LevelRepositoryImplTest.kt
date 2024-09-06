package de.hhu.campusguesserserver.db

import de.hhu.campusguesserserver.LevelMother
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever
import java.util.*

class LevelRepositoryImplTest {

    @Test
    @DisplayName("""
        Wenn ein Level in der Datenbank existiert, so wird dieser auch gefunden
    """)
    fun test_1() {
        val levelDAO: LevelDAO = mock()
        val emptyLevel = LevelMother.emptyLevelDTO()
        val levelID = LevelMother.emptyLevelDTO().id!!
        whenever(levelDAO.findById(levelID)).thenReturn(Optional.of(emptyLevel))
        val repository = LevelRepositoryImpl(levelDAO)

        val foundLevel = repository.findGuessByUuid(levelID)

        assertThat(foundLevel.isEmpty).isFalse()
    }

    @Test
    @DisplayName("""
        Wenn ein Level in aus der Datenbank geladen wird, so hat dieser auch die richtige UUID
    """)
    fun test_2() {
        val levelDAO: LevelDAO = mock()
        val emptyLevel = LevelMother.emptyLevelDTO()
        val levelID = LevelMother.emptyLevelDTO().id!!
        whenever(levelDAO.findById(levelID)).thenReturn(Optional.of(emptyLevel))
        val repository = LevelRepositoryImpl(levelDAO)

        val foundLevel = repository.findGuessByUuid(levelID).get()

        assertThat(foundLevel.id).isEqualTo(emptyLevel.id)
    }

    @Test
    @DisplayName("""
        Wenn ein Level ohne Guesses aus der Datenbank geladen wird, so hat dieser auch keine Guesses geladen
    """)
    fun test_3() {
        val levelDAO: LevelDAO = mock()
        val emptyLevel = LevelMother.emptyLevelDTO()
        val levelID = LevelMother.emptyLevelDTO().id!!
        whenever(levelDAO.findById(levelID)).thenReturn(Optional.of(emptyLevel))
        val repository = LevelRepositoryImpl(levelDAO)

        val foundLevel = repository.findGuessByUuid(levelID).get()

        assertThat(foundLevel.guessRefs).isEmpty()
    }

    @Test
    @DisplayName("""
        Wenn ein Level mit namen x aus der Datenbank geladen wird, so hat dieser mit Namen x geladen 
    """)
    fun test_4() {
        val levelDAO: LevelDAO = mock()
        val emptyLevel = LevelMother.emptyLevelDTO()
        val levelID = LevelMother.emptyLevelDTO().id!!
        whenever(levelDAO.findById(levelID)).thenReturn(Optional.of(emptyLevel))
        val repository = LevelRepositoryImpl(levelDAO)

        val foundLevel = repository.findGuessByUuid(levelID).get()

        assertThat(foundLevel.name).isEqualTo(emptyLevel.name)
    }

}