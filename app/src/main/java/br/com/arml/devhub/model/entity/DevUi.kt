package br.com.arml.devhub.model.entity

import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver

data class DevUi(
    val uuid: String,
    val name: String,
    val username: String,
    val resume: String,
    val uriPhoto: String,
    val repositories: List<RepositoryUi>,
)

val DevUiSaver: Saver<DevUi, *> = listSaver(
    save = { devUi ->
        listOf(
            devUi.uuid,
            devUi.name,
            devUi.username,
            devUi.resume,
            devUi.uriPhoto,
            devUi.repositories
        )
    },
    restore = { list ->
        @Suppress("UNCHECKED_CAST")
        DevUi(
            list[0] as String,
            list[1] as String,
            list[2] as String,
            list[3] as String,
            list[4] as String,
            list[5] as List<RepositoryUi>
        )
    }
)