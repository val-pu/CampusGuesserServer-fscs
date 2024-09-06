package de.hhu.campusguesserserver.db

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.relational.core.mapping.event.BeforeConvertCallback
import java.util.*


@Configuration
open class UUIDGenerateConfig {
    // Sorgt dafür, dass automatisch eine UUID Leveln zugewiesen wird, die in der Datenbank gespeichert werden.
    @Bean
    open fun beforeConvertCallbackLevel(): BeforeConvertCallback<LevelDTO> {
        return BeforeConvertCallback<LevelDTO> { level: LevelDTO ->
            if (level.id == null) {
                level.id = UUID.randomUUID()
            }
            level
        }
    }

    @Bean
    open fun beforeConvertCallbackGuess(): BeforeConvertCallback<GuessDTO> {
        return BeforeConvertCallback<GuessDTO> { guess: GuessDTO ->
            if (guess.id == null) {
                guess.id = UUID.randomUUID()
            }
            guess
        }
    }
}