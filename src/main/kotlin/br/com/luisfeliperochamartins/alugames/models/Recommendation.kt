package br.com.luisfeliperochamartins.alugames.models

interface Recommendation {

    val average: Double

    fun recomemend(evaluation: Int)
}