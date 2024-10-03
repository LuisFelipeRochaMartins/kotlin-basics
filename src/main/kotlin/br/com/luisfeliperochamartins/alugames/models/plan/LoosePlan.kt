package br.com.luisfeliperochamartins.alugames.models.plan

import br.com.luisfeliperochamartins.alugames.models.Rent

open class LoosePlan(type: String) : Plan(type) {

    override fun getRentValue(rent: Rent): Double {
        var originalValue = super.getRentValue(rent)

        if (rent.gamer.average > 8) {
            originalValue *= 0.9
        }

        return originalValue
    }
}
