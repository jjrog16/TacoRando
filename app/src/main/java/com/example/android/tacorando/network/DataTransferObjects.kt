package com.example.android.tacorando.network

import com.example.android.tacorando.database.DatabaseTaco
import com.example.android.tacorando.domain.TacoItem
import com.squareup.moshi.JsonClass

/**
 * DataTransferObjects go in this file. These are responsible for parsing responses from the server
 * or formatting objects to send to the server. You should convert these to domain objects before
 * using them.
 */

@JsonClass(generateAdapter = true)
data class NetworkTacoContainer(val tacos: List<NetworkTaco>)

@JsonClass(generateAdapter = true)
data class NetworkTaco(
    var url: String,
    var slug: String?,
    var name: String?,
    var recipe: String?
)

/**
 * Convert Network results to database objects
 */
fun NetworkTacoContainer.asDomainModel(): List<TacoItem> {
    return tacos.map {
        TacoItem(
            url = it.url,
            slug = it.slug,
            name = it.name,
            recipe = it.recipe
        )
    }
}

fun NetworkTacoContainer.asDatabaseModel(): Array<DatabaseTaco> {
    return tacos.map {
        DatabaseTaco(
            url = it.url,
            slug = it.slug,
            name = it.name,
            recipe = it.recipe
        )
    }.toTypedArray()
}

