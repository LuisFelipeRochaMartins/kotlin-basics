package br.com.luisfeliperochamartins.alugames.models

import kotlin.random.Random

data class Gamer(val name: String, val email: String) {

    var dateOfBirth: String ? = null
    var username: String ? = null
    var id: String ? = null

    constructor(name: String, email: String, dateOfBirth: String, username: String) : this(name, email) {
        this.dateOfBirth = dateOfBirth
        this.username = username
    }


    fun createId () {
        val number = Random.nextInt(10000)
        val tag = String.format("%04d", number)

        id = "$username#$tag"
    }

    override fun toString(): String {
        return "Gamer(name='$name', email='$email', dateOfBirth=$dateOfBirth, username=$username, id=$id)"
    }
}
