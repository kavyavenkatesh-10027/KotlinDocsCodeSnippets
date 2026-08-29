package beginner.basicTypes

fun main() {
    declaringIntegralValue()
    automaticTypeCheckSizeBased()
    defaultIntegralTypeInference()
    declaringFloatingPointValues()
    defaultFloatingTypeInference()
    arithmeticOperants()
    typeConversions()
    mixedNumericalExpressions()
    dataOverflow()
    bitwiseOperations()
    floatingPointNumberOperants()
    boxingAndCachingNumbersInJVM()
}

/**
 * "INTEGRAL TYPES"
 */


/**
| Type       | Size(Bits)     | MIN value      | MAX value  |
|------------|----------------|----------------|------------|
| Byte       |     8          | -128           | 127        |
| Short      |     16         | -32768         | 32767      |
| Int        |     32         | -2^32          | 2^32-1     |
| Long       |     64         | -2^64          | 2^64-1     |
 */

fun declaringIntegralValue(){
    //To declare a numeric value, we must specify the type explicitly:

    val one: Int = 1

// Use underscores to improve readability
    val oneBillion: Long = 1_000_000_000
    val hexBytes: Int = 0x7F_EC_DE_5E
    val bytes: Int = 0b01010010_01101001_10010100_10010010

    val oneByte: Byte = 1
    val oneShort: Short = 1

//You can also append the L suffix, to declare a Long value:

    val oneLong = 1L
    /**This would still be considered as a declaration**/
}

/*
Kotlin supports the following literal forms for integer values:
    Decimals: 123
    Hexadecimals: 0x0F
    Binaries: 0b00001011

    note: Kotlin does not support octal literals.
 */

val maybeAbsent: Int? = null
/**
If a value can be absent, use nullable types:
 */


fun automaticTypeCheckSizeBased() {
    //When you declare a numeric type explicitly, the compiler checks
    //that the value fits in the range of that type:

// Value fits in Byte
    val oneByte: Byte = 1

    /**
    Error: the value does not fit in Byte

    val tooBig: Byte = 128
    **/
}

fun defaultIntegralTypeInference() {
    //When you do not specify a numeric type, Kotlin infers Int if the
    // value fits in the Int range. Otherwise, Kotlin infers Long:

    val million = 1_000_000 // Int
    val threeBillion = 3_000_000_000 // Long
}






/**
  *  "FLOATING POINT TYPES"
 */

/*
Floating-point types follow the IEEE 754 standard.
Float reflects the single precision. Double reflects the double precision.
 */

/**
 |Type      | Size(Bits)         | Significant         | Exponent        | Decimal Points   |
 |----------|--------------------|---------------------|-----------------|------------------|
 |Float     |    32      `       | 23+1  `             | 8               | 6-7 digits       |
 |Double    |    64              | 52+1                | 11              | 15-16 digits     |

 +1 is for sign, Positive(+, 0) or Negative(-, 1) bit
 */

fun declaringFloatingPointValues() {
    //Declare floating -point values

    //To declare a floating -point literal, include a decimal point (.) or use exponent notation:

    val pi = 3.14//(.)
    val avogadro = 6.02214076e23//(e) Exponential
}

fun defaultFloatingTypeInference() {
    //By default, Kotlin infers floating-point literals as Double.
    //To declare a Float, add the f or F suffix:

    val pi = 3.14 // Double
    val eFloat = 2.7182817f // Float

    /*
  note : Kotlin rounds a Float literal that contains more precision than Float can store.
 */
}

val possiblyAbsent: Double? = null
/**
If a value can be absent, use nullable types:
 */

fun arithmeticOperants(){
    /*Kotlin supports the standard arithmetic operations on numbers: +, -, *, /, and %.*/
    println(1 + 2) // 3
    println(2_500_000_000L - 1L) // 2499999999
    println(3.14 * 2.71) // 8.5094
    println(10.0 / 3) // 3.3333333333333335


    /**Division between integer values always returns an integer result. The compiler discards the fractional part:**/

    val intValue = 5 / 2
    println(intValue) // 2

    val longValue = 5L / 2
    println(longValue) // 2


    /**To return a floating-point result, make at least one operand a Float or Double:*/
    val a = 5 / 2.0
    println(a) // 2.5
}

fun typeConversions(){
    /**
    Type conversion
     */

    //Numeric types are not subtypes of one another.
    //Kotlin requires explicit conversions to avoid silent data loss and unexpected behavior.


    //For example, a function that expects Double cannot accept an Int or a Float value without conversion:

    fun printDouble(x: Double) {
        print(x)
    }


    val x = 1.0
    val xInt = 1
    val xFloat = 1.0f

/*
 val one: Double = 1  Error: initializer type mismatch
 */

    printDouble(x)

/*
printDouble(xInt)  Error: argument type mismatch
printDouble(xFloat) // Error: argument type mismatch
*/


/**
All number types support conversions to other number types. To convert a number to another type, use an explicit conversion function:

    toByte()

    toShort()

    toInt()

    toLong()

    toFloat()

    toDouble()
**/

    /*
    For example, the following code converts an Int value to Double:
     */

    val intValue: Int = 1

    val doubleValue = intValue.toDouble()

    println(doubleValue) // 1.0

    /**
     * note:  When you convert a floating-point value to an integer type, the compiler discards the fractional part:
     */

    val d: Double = 1.5
    val l: Long = d.toLong()

    println(l)

    /** Prints 1*/

}

fun mixedNumericalExpressions(){
    val intNumber: Int = 1
    val longNumber: Long = 1000
    val result = intNumber + longNumber // 1001, Long
    //Bigger one takes precedence

    /*
    val intNumber: Int = 1
    val longNumber: Long = 1000
    val result: Int = intNumber + longNumber
     */

    /**Error: Initializer type mismatch*/
}


fun dataOverflow(){
    /*
    Numeric types can represent only values within their defined ranges.

    If the result of an operation falls outside that range, overflow occurs.
    If you convert a value to a smaller numeric type, the converted value may
    not preserve the original numeric value.
     */

/**
    This behavior can affect the result of your code even when the compiler accepts it.
**/



    /*
        A. Overflow in operation
    */

    //Each integer type can store only values within its defined range.
    //When the result of an arithmetic operation exceeds that range, data overflow occurs:


        val intNumber: Int = 2147483647

        // Max Int value is 2147483647

        println(intNumber + 1) // -2147483648


/**
    Here, the result wraps around because the value no longer fits in Int.
**/

/** note :  The compiler does not automatically produce an error when integer overflow occurs.*/


    /*
        B. Overflow in negation
    */


/**
    Overflow can also occur during negation. For example, you cannot represent the positive
    counterpart of Int.MIN_VALUE as an Int.
**/

    val min = Int.MIN_VALUE

    println(-min) // -2147483648


    /*
        C. Narrowing Conversions
    */

/**
    When you convert a value to a smaller integer type, the result may not preserve the original
    numeric value:
*/

    val large: Int = 130
    val narrowed: Byte = large.toByte()


    println(narrowed) // -126

/** Floating-point types with very large results can become Infinity: */

    println(Double.MAX_VALUE * 2) // Infinity

}


fun bitwiseOperations() {

    /*
    Kotlin provides bitwise operations for Int and Long. These operations are represented
    by a set of infix functions and inv().
     */

    /**
    Bitwise operations include:

    shl() – signed shift left

    shr() – signed shift right

    ushr() – unsigned shift right

    and() – bitwise AND

    or() – bitwise OR

    xor() – bitwise XOR

    inv() – bitwise inversion
     */

    val a = 12      // 1100
    val b = 10      // 1010

    println("a = $a")
    println("b = $b")

    // AND
    println("a and b      = ${a and b}")      // 1000 = 8

    // OR
    println("a or b       = ${a or b}")       // 1110 = 14

    // XOR
    println("a xor b      = ${a xor b}")      // 0110 = 6

    // Inversion (NOT)
    println("a.inv()      = ${a.inv()}")      // -13

    // Left Shift
    println("a shl 2      = ${a shl 2}")      // 110000 = 48

    // Signed Right Shift
    println("a shr 2      = ${a shr 2}")      // 0011 = 3

    // Unsigned Right Shift
    println("a ushr 2     = ${a ushr 2}")     // 3

}

fun floatingPointNumberOperants(){
    /*
     * Usually Nan != Nan
     * 0.00 == -0.00
     * Nan is not a Number
     */

    /**
        During common calculations such as Any, Comparable<>, or Collections, rules followed:

            NaN is considered equal to itself

            NaN is considered greater than any other element including POSITIVE_INFINITY

            -0.0 is considered less than 0.0
     */

    fun generalizedEquals(a: Any, b: Any): Boolean {
        return a == b
    }

    // Operands statically typed as floating-point numbers
    println(Double.NaN == Double.NaN) // false
    println(0.0 == -0.0) // true

    // Operands used through a non-floating-point static type
    println(generalizedEquals(Double.NaN, Double.NaN)) // true
    println(generalizedEquals(0.0, -0.0)) // false
}

fun boxingAndCachingNumbersInJVM() {
    /*
    On the JVM, non-nullable numeric values are usually stored using primitive types,
    such as int, long, or double. However, when you use generic types or nullable numeric types like
    Int?, the value is boxed and represented as an object.
    */

    /**
     * The JVM applies a memory optimization technique to small numbers by caching their boxed
     * representations. As a result, boxed numbers with the same value can be referentially equal.
     */


    //For example, the JVM caches boxed Integer values in the range -128 to 127.
    //Therefore, the following code returns true:


    val score1: Int = 100

    val savedScore1: Int? = score1

    val displayedScore1: Int? = score1



    println(savedScore1 === displayedScore1) // true


    /**
     * For values outside the cached range, boxed values are separate objects. In that case,
     * they are not referentially equal, even if their values are structurally equal.
     * For this reason, use == to compare numeric values:
     */

    val score2: Int = 10000

    val savedScore2: Int? = score2

    val displayedScore2: Int? = score2



    println(savedScore2 === displayedScore2) // false

    println(savedScore2 == displayedScore2) // true
}