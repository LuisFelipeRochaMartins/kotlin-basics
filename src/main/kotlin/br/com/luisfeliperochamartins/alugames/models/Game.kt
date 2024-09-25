package br.com.luisfeliperochamartins.alugames.models

data class Game(val title: String, val cover: String) {
    var description : String ? = null

    override fun toString(): String {
        return "Game(title='$title', cover='$cover', description=$description)"
    }


}