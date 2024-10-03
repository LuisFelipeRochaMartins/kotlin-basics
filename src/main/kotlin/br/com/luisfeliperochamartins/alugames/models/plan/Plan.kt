package br.com.luisfeliperochamartins.alugames.models.plan

import br.com.luisfeliperochamartins.alugames.models.Rent

sealed class Plan(val type: String) {

    open fun getRentValue(rent: Rent): Double {
        return rent.game.price * 0.4 * rent.periodOfDays.inDays
    }
}
