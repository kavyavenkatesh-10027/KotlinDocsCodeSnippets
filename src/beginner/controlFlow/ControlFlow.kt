package beginner.controlFlow

fun main(){
    ifStatement()
    ifExpression()
    whenBranchAsStatement()
    whenBranchAsExpression()
    whileLoop()
    doWhileLoop()
    returnUsingAtLoop()
    returnFromExplicitLabel()
    returnFromImplicitLabels()
    returnAsBreak()
}

//IF Statement
fun ifStatement(){
    val d: Int
    val check = true

    if (check) {
        d = 1
    } else {
        d = 2
    }

    println(d)
}

fun ifExpression(){
    val heightAlice = 160
    val heightBob = 175

    val taller = if (heightAlice > heightBob) {
        print("Choose Alice\n")
        heightAlice
    } else {
        print("Choose Bob\n")
        heightBob
    }

    println("Taller height is $taller")
}

//WHEN
/*
Can be used with.or.without a subject
 */
fun whenBranchAsStatement(){
    val obj = "Hello"

    when (obj) {
        // Checks whether obj equals to "1"
        "1" -> println("One")
        // Checks whether obj equals to "Hello"
        "Hello" -> println("Greeting")
        // Default statement
        else -> println("Unknown")
    }
// Greeting
}

fun whenBranchAsExpression(){
    val obj = "Hello"

    val result = when (obj) {
        // If obj equals "1", sets result to "one"
        "1" -> "One"
        // If obj equals "Hello", sets result to "Greeting"
        "Hello" -> "Greeting"
        // Sets result to "Unknown" if no previous condition is satisfied
        else -> "Unknown"
    }
    println(result)
// Greeting
}

/**
    Ranges

    The most common way to create a range in Kotlin is to use the .. operator.
     * For example, 1..4 is equivalent to 1, 2, 3, 4.

    To declare a range that doesn't include the end value, use the ..< operator.
     * For example, 1..<4 is equivalent to 1, 2, 3.

    To declare a range in reverse order, use downTo.
    For example, 4 downTo 1 is equivalent to 4, 3, 2, 1.

    To declare a range that increments in a step that isn't 1, use step and your
    desired increment value.
     * For example, 1..5 step 2 is equivalent to 1, 3, 5.

 * You can also do the same with Char ranges:

      'a'..'d' is equivalent to 'a', 'b', 'c', 'd'

      'z' downTo 's' step 2 is equivalent to 'z', 'x', 'v', 't'
 **/

/*
println("Closed-ended range:")
for (i in 1..6) {
    print(i)
}
// Closed-ended range:
// 123456

println("\nOpen-ended range:")
for (i in 1..<6) {
    print(i)
}
// Open-ended range:
// 12345

println("\nReverse order in steps of 2:")
for (i in 6 downTo 0 step 2) {
    print(i)
}
// Reverse order in steps of 2:
// 6420
 */

//FOR Loop
fun incrementedForLoop(){
    for (number in 1..5) {
        // number is the iterator and 1..5 is the range
        print(number)
    }
}

fun enhancedForLoop(){
    val cakes = listOf("carrot", "cheese", "chocolate")

    for (cake in cakes) {
        println("Yummy, it's a $cake cake!")
    }
}

//WHILE And DO-WHILE:
fun whileLoop(){
    var cakesEaten = 0
    while (cakesEaten < 3) {
        println("Eat a cake")
        cakesEaten++
    }
}

fun doWhileLoop(){
    var cakesEaten = 0
    var cakesBaked = 0
    while (cakesEaten < 3) {
        println("Eat a cake")
        cakesEaten++
    }
    do {
        println("Bake a cake")
        cakesBaked++
    } while (cakesBaked < cakesEaten)
}

//RETURN USING LABELS
/**
 * Below three function return's function behaves as 'continue'
 */
fun returnUsingAtLoop(){
    loop@ for (i in 1..100) {
        for (j in 1..100) {
            if (i==60) break@loop
        }
    }
}

fun returnFromExplicitLabel() {
    listOf(1, 2, 3, 4, 5).forEach lit@{
        if (it == 3) return@lit // local return to the caller of the lambda - the forEach loop
        print(it)
    }
    print(" done with explicit label")
}

fun returnFromImplicitLabels() {
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) return@forEach // local return to the caller of the lambda - the forEach loop
        print(it)
    }
    print(" done with implicit label")
}

/** For 'break' equivalent we use return after enclosing the exiting code with a run loop.**/

fun returnAsBreak() {
    run loop@{
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return@loop // non-local return from the lambda passed to run
            print(it)
        }
    }
    print(" done with nested loop")
}