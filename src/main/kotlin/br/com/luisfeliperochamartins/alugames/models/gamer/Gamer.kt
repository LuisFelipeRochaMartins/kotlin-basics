package br.com.luisfeliperochamartins.alugames.models.gamer

import br.com.luisfeliperochamartins.alugames.models.game.Game
import br.com.luisfeliperochamartins.alugames.models.PeriodOfDays
import br.com.luisfeliperochamartins.alugames.models.Recommendation
import br.com.luisfeliperochamartins.alugames.models.Rent
import br.com.luisfeliperochamartins.alugames.models.plan.LoosePlan
import java.util.Scanner
import kotlin.random.Random

data class Gamer(var name: String, var email: String) {

    var dateOfBirth: String ? = null
    var username: String ? = null
        set(value) {
            field = value
            if (id.isNullOrBlank()) {
                createId()
            }
        }
    var id: String ? = null
        private set
    val plan = LoosePlan("BRONZE")
    val searchGames = mutableListOf<Game?>()
    private val rentedGames = mutableListOf<Rent?>()


    constructor(name: String, email: String, dateOfBirth: String, username: String) : this(name, email) {
        this.dateOfBirth = dateOfBirth
        this.username = username
        createId()
    }

    init {
        this.name = validateName()
        this.email = validateEmail()
    }

    fun createId() {
        val number = Random.nextInt(10000)
        val tag = String.format("%04d", number)

        id = "$username#$tag"
    }

    fun validateEmail(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email)) {
            return email
        }
        throw IllegalArgumentException("Email invalid!")
    }

    fun validateName(): String {
        val isEmpty = name.isNullOrBlank()
        if (isEmpty) {
            throw IllegalArgumentException("Name invalid")
        }
        return name
    }

    fun rentGame(game: Game, periodOfDays: PeriodOfDays): Rent {
        val rent = Rent(this, game, periodOfDays)
        rentedGames.add(rent)

        return rent
    }

    fun gamesRentedAtMonth(mes:Int): List<Game> {
        return rentedGames
            .filter { rent ->  rent!!.periodOfDays.startOfRent.monthValue == mes}
            .map { rent ->  rent!!.game}
    }

    fun recommendGame(game: Game, evaluation: Int) {
        game.recommend(evaluation)
        game.recommendedGames.add(game)
    }

    companion object {
        fun createGamer(input: Scanner): Gamer {
            print("Welcome to AluGames! Let's make your register. What is your name? :")
            val name = input.nextLine()

            print("Type your email: ")
            val email = input.nextLine()

            println("Wish to complete your register with username and date of birht? (Y/N)")
            val opcao = input.nextLine()

            if (opcao.equals("y", true)) {
                print("Type your date of birth(DD/MM/YYYY): ")
                val date = input.nextLine()

                print("Type your username: ")
                val username = input.nextLine()

                return Gamer(name, email, date, username)
            }
            return Gamer(name, email)
        }
    }

    override fun toString(): String {
        return "Gamer(name='$name', email='$email', dateOfBirth=$dateOfBirth, username=$username, id=$id, plan=$plan, searchGames=$searchGames, rentedGames=$rentedGames)"
    }
}
