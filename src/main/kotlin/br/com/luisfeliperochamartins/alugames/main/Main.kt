package br.com.luisfeliperochamartins.alugames.main

import br.com.luisfeliperochamartins.alugames.models.Game
import br.com.luisfeliperochamartins.alugames.services.RequestHandler

import java.util.Scanner

fun main() {
    val input = Scanner(System.`in`)
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
        println(game)
    }
}