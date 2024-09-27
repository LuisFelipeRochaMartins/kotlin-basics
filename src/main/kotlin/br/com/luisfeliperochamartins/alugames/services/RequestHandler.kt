package br.com.luisfeliperochamartins.alugames.services

import br.com.luisfeliperochamartins.alugames.models.*
import br.com.luisfeliperochamartins.alugames.utils.toGame
import com.google.gson.Gson
import br.com.luisfeliperochamartins.alugames.utils.toGamer
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class RequestHandler {

    private val gson = Gson()

    fun findGameById(id: String): InfoGame {
        val adress = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val json = fetch(adress)

        return gson.fromJson(json, InfoGame::class.java)
    }

    fun findGamers(): List<Gamer> {
        val adress = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

        val json = fetch(adress)

        val type = object : TypeToken<List<InfoGamer>>() {}.type
        val listaGamers : List<InfoGamer> = gson.fromJson(json, type)

        return listaGamers.map { infoGamer -> infoGamer.toGamer() }
    }

    fun findGames(): List<Game> {
        val adress = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
        val json = fetch(adress)

        val type = object: TypeToken<List<InfoGameJson>>() {}.type
        val gamesList: List<InfoGameJson> = gson.fromJson(json, type)

        return gamesList.map { infoGame -> infoGame.toGame() }
    }

    private fun fetch(adress: String): String {
        val client = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(adress))
            .build()

        val response = client.send(request, BodyHandlers.ofString())
        return response.body()
    }
}