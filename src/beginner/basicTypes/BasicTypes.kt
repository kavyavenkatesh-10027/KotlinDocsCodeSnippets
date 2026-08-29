package beginner.basicTypes

fun main() {

    val a: Int = 1000
    val b: String = "log message"
    val c: Double = 3.14
    val d: Long = 100_000_000_000_000
    val e: Boolean = false
    val f: Char = '\n'



    /**
     *Variable can be declared without initialization
     as long as they initialized before use
     */

    // Variable declared without initialization
    val number: Int
    // Variable initialized
    number = 3

    var sentence: String
    sentence = "Yes, it works with var as well"

    // Variable explicitly typed and initialized
    val word: String = "hello"

    println(number) // 3
    println(word) // hello

    /*
// Variable declared without initialization
    val d: Int

// Triggers an error
    println(d)
// Variable 'd' must be initialized
     */

}