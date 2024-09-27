package br.com.luisfeliperochamartins.alugames.models

import java.time.LocalDate
import java.time.Period

data class PeriodOfDays(val startOfRent: LocalDate, val endOfRent: LocalDate) {
    val inDays = Period.between(startOfRent, endOfRent).days
}
