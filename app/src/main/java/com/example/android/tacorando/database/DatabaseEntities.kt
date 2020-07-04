package com.example.android.tacorando.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.tacorando.domain.TacoItem

@Entity
data class DatabaseEntities constructor(
    @PrimaryKey
    val url: String,
    val slug: String?,
    val name: String?,
    val recipe: String?
)

// Take what is in the database and make that the TacoItem
fun List<DatabaseEntities>.asDomainModel(): List<TacoItem> {
    return map {
        TacoItem(
            url = it.url,
            slug = it.slug,
            name = it.name,
            recipe = it.recipe
        )
    }
}