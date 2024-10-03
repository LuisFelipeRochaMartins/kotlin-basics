package br.com.luisfeliperochamartins.alugames.models.game

import br.com.luisfeliperochamartins.alugames.models.InfoApiShark

data class InfoGame(val info: InfoApiShark) {

    override fun toString(): String {
        return info.toString()
    }
}