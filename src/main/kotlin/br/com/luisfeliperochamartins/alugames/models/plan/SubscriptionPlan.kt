package br.com.luisfeliperochamartins.alugames.models.plan

import br.com.luisfeliperochamartins.alugames.models.Rent

class SubscriptionPlan(type: String,
                       val fee: Double,
                       private val includedGames: Int,
                       private val discountPercentage: Double) : Plan(type) {

    override fun getRentValue(rent: Rent) : Double {
        val totalGamesRented = rent.gamer.gamesRentedAtMonth(rent.periodOfDays.startOfRent.monthValue).size

        return if (totalGamesRented <= includedGames)  {
            0.0
        } else {
            var originalValue = super.getRentValue(rent)
            if (rent.gamer.average > 8) {
                originalValue -= originalValue * discountPercentage
            }
            originalValue
        }
    }
}