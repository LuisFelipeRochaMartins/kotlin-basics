package br.com.luisfeliperochamartins.alugames.utils

import br.com.luisfeliperochamartins.alugames.models.gamer.Gamer
import br.com.luisfeliperochamartins.alugames.models.gamer.InfoGamer

fun InfoGamer.toGamer(): Gamer {
    return Gamer(this.name, this.email, this.dateBirth, this.username)
}