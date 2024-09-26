package br.com.luisfeliperochamartins.alugames.main

import br.com.luisfeliperochamartins.alugames.models.Game
import br.com.luisfeliperochamartins.alugames.models.Gamer
import br.com.luisfeliperochamartins.alugames.services.RequestHandler
import br.com.luisfeliperochamartins.alugames.utils.transformAge

import java.util.Scanner

fun main() {
    val input = Scanner(System.`in`)
    val gamer = Gamer.createGamer(input)

    println("Register Sucessed!")
    println("Age of the gamer of: ${gamer.dateOfBirth?.transformAge()}")

    while (true) {
        print("Type a game code to search: ")

        val search = input.nextLine()
        val api = RequestHandler()

        val infoGame = api.findGameById(search)
        var game : Game? = null

        val resultado = runCatching {
            game = Game(
                infoGame.info.title,
                infoGame.info.thumb
            )
        }

        resultado.onFailure {
            print("Jogo inexistente. Tente outro id.")
        }

        resultado.onSuccess {
            println("Wish to add a custom descripton ? Y/N")
            val opcao = input.nextLine()
            if (opcao.equals("y", true)) {
                print("Type the description you want to add: ")
                val descricaoPersonalizada = input.nextLine()
                game?.description = descricaoPersonalizada
            } else {
                game?.description = game?.title
            }

            gamer.searchGames.add(game)
        }

        println("Want to add search another game? Y/N")
        val resposta = input.nextLine()

        if (!resposta.equals("y", true)) {
            break
        }
    }

    println("Games Searched")
    gamer.searchGames.sortBy {
        it?.title
    }

    gamer.searchGames.forEach {
        println("Title: " + it?.title)
        println("description: " + it?.description)
    }
}