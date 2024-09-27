package br.com.luisfeliperochamartins.alugames.utils

import br.com.luisfeliperochamartins.alugames.models.Game
import br.com.luisfeliperochamartins.alugames.models.InfoGameJson

fun InfoGameJson.toGame(): Game {
    return Game(this.title, this.cover, this.preco, this.description)
}