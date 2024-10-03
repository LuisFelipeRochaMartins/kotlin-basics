package br.com.luisfeliperochamartins.alugames.models

import br.com.luisfeliperochamartins.alugames.models.game.Game
import br.com.luisfeliperochamartins.alugames.models.gamer.Gamer

data class Rent(val gamer: Gamer,
                val game: Game,
                val periodOfDays: PeriodOfDays) {
    private val rentPrice = gamer.plan.getRentValue(this)

    override fun toString(): String {
        return "Rent of ${game.title} by ${gamer.name} for the value of USD $rentPrice"
    }
}
