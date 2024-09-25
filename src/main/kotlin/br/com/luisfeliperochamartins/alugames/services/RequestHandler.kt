package br.com.luisfeliperochamartins.alugames.services

import com.google.gson.Gson
import br.com.luisfeliperochamartins.alugames.models.InfoGame
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class RequestHandler {

    fun findGameById(id: String): InfoGame {
        val adress = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val client = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(adress))
            .build()

        val response = client.send(request, BodyHandlers.ofString())
        val json = response.body()
        val gson = Gson()

        return gson.fromJson(json, InfoGame::class.java)
    }
}