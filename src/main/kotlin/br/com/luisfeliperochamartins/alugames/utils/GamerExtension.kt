package br.com.luisfeliperochamartins.alugames.utils

import br.com.luisfeliperochamartins.alugames.models.Gamer
import br.com.luisfeliperochamartins.alugames.models.InfoGamer

fun InfoGamer.toGamer(): Gamer {
    return Gamer(this.name, this.email, this.dateBirth, this.username)
}