// Welcome welcome!!

// Create class
class Word {
    val userWord = mutableListOf("s", "h", "a", "l", "o", "m")
    val guessedLetters = mutableListOf<String>()
    // TODO Return word to be checked against the user's input rather than hardcoding in

    fun checkLetterToGuess(letter : String) : Boolean {
        /* takes a String and returns a boolean if the letter is in a list */
        if (letter in userWord && letter !in guessedLetters) {
            guessedLetters.add(letter)
            println("Congrats! that letter '$letter' is in the word. ")
            return true

        }
        else {
            return false
        }
    }
}

class Player {
    // Lives to calculate game ending condition
    var lives = 5

    fun getUserLetter(): String {
        // Gets User input
        println("Guess a letter: ")
        return readLine()!!

        //  TODO Eventually pass this is so that the valid letters are removed if they have previously guessed that letter.
        //    val validLetters = mutableListOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
        //    // Catch error of not inputting a valid character
        //    while (letter.toString() !in validLetters) {
        //        println("You entered an invalid character.")
        //        println("Guess a letter: ")
        //        val letter = readLine()
        //    }
        //    println("You entered: $letter")
    }

}

fun printGreeting() {
    println("----------------------------------------------")
    println("                  HANGMAN")
    println("----------------------------------------------\n")
    println("Rules: \n1. Enjoy Yourself\n2. Guess Letters\n\n")
}

fun main(args: Array<String>) {
    // classes
    val player = Player()
    val word = Word()
    var correct = true
    val printable = mutableListOf("_", "_", "_", "_", "_", "_")

    // variables/lists
    var notDone = true

    // Initial setup
    printGreeting()

    // Main game loop
    while (notDone) {
        // Retrieves a guess to be checked against the word selected.
        correct = word.checkLetterToGuess(player.getUserLetter())

        if (!correct) {
            player.lives -= 1
            println("You have ${player.lives} live/s left")
        }

        if (player.lives == 0) {
            println("---------------Game Over---------------")
            notDone = false
        }

        // prints correctly guessed letter in the right spot to be shown to user.
        for ( letter in word.guessedLetters ) {
            var index = word.userWord.indexOf(letter)
            printable[index] = letter
        }

        // To make sure that there are no remaining letters to be guessed
        println(printable)
        if ("_" !in printable ) {
            notDone = false
        }

        }

}