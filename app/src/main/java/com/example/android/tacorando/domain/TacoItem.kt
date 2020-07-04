package com.example.android.tacorando.domain


/**
 * Domain objects are plain Kotlin data classes that represent the things in our app. These are the
 * objects that should be displayed on screen, or manipulated by the app.
 *
 * @see database for objects that are mapped to the database
 * @see network for objects that parse or prepare network calls
 */


/**
 * TacoItem represent an item of a taco, such as the shell, base layer, or condiments.
 */
data class TacoItem(
    var url: String?,
    var slug: String?,
    var name: String?,
    var recipe: String?
)