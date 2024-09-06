package de.hhu.campusguesserserver.db.integration

import de.hhu.campusguesserserver.LevelMother
import de.hhu.campusguesserserver.db.LevelDAO
import de.hhu.campusguesserserver.db.LevelRepositoryImpl
import de.hhu.campusguesserserver.services.ILevelRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest

@DataJdbcTest
open class DBTests {

    @Autowired
    lateinit var levelDAO: LevelDAO
    lateinit var levelRepo: ILevelRepository

    @BeforeEach
    fun setUp() {
        levelRepo = LevelRepositoryImpl(levelDAO)
    }

    @Test
    fun test_1() {
        val level = LevelMother.levelWithTwoRandomGuessIds()
        levelRepo.save(level)
    }

}