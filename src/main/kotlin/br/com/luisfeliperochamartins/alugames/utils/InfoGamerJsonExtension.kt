package br.com.luisfeliperochamartins.alugames.utils

import br.com.luisfeliperochamartins.alugames.models.game.Game
import br.com.luisfeliperochamartins.alugames.models.game.InfoGameJson

fun InfoGameJson.toGame(): Game {
    return Game(this.title, this.cover, this.preco, this.description)
}