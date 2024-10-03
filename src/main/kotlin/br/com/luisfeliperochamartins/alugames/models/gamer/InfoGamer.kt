package br.com.luisfeliperochamartins.alugames.models.gamer

import com.google.gson.annotations.SerializedName

data class InfoGamer(@SerializedName("nome") val name: String,
                     val email: String,
                     @SerializedName("dataNascimento") val dateBirth: String,
                     @SerializedName("usuario") val username: String) {


}
