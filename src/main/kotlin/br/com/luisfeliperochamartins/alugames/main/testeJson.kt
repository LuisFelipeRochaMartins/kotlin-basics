package br.com.luisfeliperochamartins.alugames.main

import br.com.luisfeliperochamartins.alugames.models.PeriodOfDays
import br.com.luisfeliperochamartins.alugames.services.RequestHandler
import java.time.LocalDate

fun main() {
    val request = RequestHandler()
    val gamers = request.findGamers()
    val games = request.findGames()

    val period = PeriodOfDays(LocalDate.now().minusDays(3), LocalDate.now().plusDays(2))

    val gamer = gamers.get(2)
    val game = games.get(10)

    val rent = gamer.rentGame(game, period)
    println(rent)
}