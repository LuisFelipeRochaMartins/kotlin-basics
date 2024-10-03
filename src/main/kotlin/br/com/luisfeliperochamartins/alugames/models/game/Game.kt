package br.com.luisfeliperochamartins.alugames.models.game

import br.com.luisfeliperochamartins.alugames.models.Recommendation
import com.google.gson.annotations.Expose

data class Game(@Expose val title: String, @Expose val cover: String) : Recommendation {
    var description : String ? = null
    var price = 0.0
    val recommendedGames = mutableListOf<Game>()

    override val average: Double
        get() = evaluationList.average()

    override fun recommend(evaluation: Int) {
        evaluationList.add(evaluation)
    }

    private val evaluationList= mutableListOf<Int>()

    constructor(title: String, cover: String, price: Double, description: String): this(title, cover) {
        this.price = price;
        this.description = description
    }

    override fun toString(): String {
        return "Game(title='$title', cover='$cover', description=$description)"
    }
}