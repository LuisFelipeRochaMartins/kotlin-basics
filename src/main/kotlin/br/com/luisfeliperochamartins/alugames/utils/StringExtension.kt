package br.com.luisfeliperochamartins.alugames.utils

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun String.transformAge(): Int {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val dateBirth = LocalDate.parse(this, formatter)

    return Period.between(
        dateBirth,
        LocalDate.now()
    ).years
}