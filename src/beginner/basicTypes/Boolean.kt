package beginner.basicTypes

val isTrue: Boolean = true
val isFalse = false // Kotlin infers Boolean

val isEnabled: Boolean? = null// null values allowed with nullable Boolean?

/**
  You cannot assign an integer value to a Boolean variable.
  In Kotlin, 0 and 1 are not Boolean values.
 */

fun main() {
    val number = 10
    val isPositive = number > 0
    println(isPositive) // true

    if (isPositive) {
        println("The number is positive.")
    }

    val language = "Kotlin"
    val isEmpty = language.isEmpty()
    println(isEmpty) // false

    booleanOperations()
    booleanPrecedence()
    booleanInConditions()
}

fun booleanOperations(){

    /*
        Negation
     */

    //The NOT operator inverts a Boolean value.


    val isOn = true
    val isOff = !isOn // isOff is false

    /*
        Logical AND
     */

    //The AND operator returns true only if both operands are true.


    val a = false && false // false
    val b = false && true // false
    val c = true && false // false
    val d = true && true  // true

    /**
    note :   If the first operand is false, the && operator skips the second operand. To evaluate both operands, use the and infix function instead.
    */


    /*
        Logical OR
     */

    //The OR operator returns true if at least one operand is true.

    val e = false || false // false
    val f = false || true  // true
    val g = true || false  // true
    val h = true || true   // true

    /**
    note :   If the first operand is true, the || operator skips the second operand.
    To evaluate both operands, use the or infix function instead.
     */

   /*
        Exclusive OR (XOR)
    */

    //The exclusive OR (XOR) operation returns true if the operands have different values.

    val l = false xor false // false
    val m = false xor true  // true
    val n = true xor false  // true
    val o = true xor true   // false

    /** note :   xor is an infix function, not an operator. */
}

fun booleanPrecedence(){
    /**
     If an expression contains multiple logical operations and no parentheses to specify
     the evaluation order, Kotlin applies precedence rules. Operations with higher precedence
     are evaluated before operations with lower precedence.
     */

    val resultWithPrecedence = true || false && false
    println(resultWithPrecedence) // true

    val result = (true || false) && false
    println(result) // false
}

fun booleanInConditions(){

    /**
        if expressions
     */

    val num1 = 4
    val isEven = num1 % 2 == 0

    // Condition already has the `Boolean` type
    // You do not need to compare it to `true` or `false`
    if (isEven) {
        println("The number is even.")
    } else {
        println("The number is odd.")
    }


    /**
        when expressions
     */

    val num2 = 3

    when {
        num2 > 0 -> println("The number is positive.")
        num2 < 0 -> println("The number is negative.")
        else -> println("The number is zero.")
    }


    /**
        while loops
     */

    var isCalculating = true

    while (isCalculating) {
        println("Calculating...")
        isCalculating = false
    }
}

