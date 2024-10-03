package br.com.luisfeliperochamartins.alugames.models.game

import com.google.gson.annotations.SerializedName

data class InfoGameJson(@SerializedName("titulo") val title: String,
                        @SerializedName("capa") val cover: String,
                        @SerializedName("preco") val preco: Double,
                        @SerializedName("descricao") val description: String) {
}