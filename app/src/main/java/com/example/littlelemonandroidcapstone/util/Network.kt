package com.example.littlelemonandroidcapstone.util

import com.example.littlelemonandroidcapstone.domain.model.MenuItem
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.Serializable

object Network {
    private val httpClient = HttpClient(Android) {
        install(ContentNegotiation) {
            json(contentType = ContentType("text", "plain"))
        }
    }

    private suspend fun fetchMenu(): List<MenuItemNetwork> {
        val url =
            "https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json"
        val menuNetwork = httpClient.get(url).body<MenuNetwork>()
        return menuNetwork.menu
    }

    suspend fun getMenuItemsFromNetwork(): List<MenuItem> {
        val menuItemsNetwork = fetchMenu()
        return menuItemsNetwork.map { it.toMenuItemRoom() }
    }


}


@Serializable
data class MenuNetwork(
    val menu: List<MenuItemNetwork>
)

@Serializable
data class MenuItemNetwork(
    val id: Int,
    val title: String,
    val description: String,
    val price: String,
    val image: String,
    val category: String
) {
    fun toMenuItemRoom() = MenuItem(
        id,
        title,
        description,
        price,
        image,
        category
    )
}
