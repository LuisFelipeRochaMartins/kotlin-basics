package br.com.luisfeliperochamartins.alugames.models

data class Rent(val gamer: Gamer,
                val game: Game,
                val periodOfDays: PeriodOfDays) {
    val rentPrice = game.price * 0.4 * periodOfDays.inDays

    override fun toString(): String {
        return "Rent of ${game.title} by ${gamer.name} for the value of USD $rentPrice"
    }
}
