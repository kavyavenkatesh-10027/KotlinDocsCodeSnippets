package beginner.basicTypes

/*
The Char type represents a single character as a UTF-16 code unit.
 */

/*
val invalid = 'AB' : Error
val invalidEmpty = '' : Error
 */

fun unicodeSupport(){

    fun basicMultiLingualPlane() {

        /**
        A single Char can store values in the range from \u0000 to \uFFFF.
        This range covers the Basic Multilingual Plane (BMP) that includes
        characters for almost all modern languages and a large number of symbols.
         **/

        /*
    To specify a character by the Unicode value, use \u followed by four-digit hexadecimal
    value from the Unicode table:
     */

        val unicodeNumber = '\u0031' // Equals '1'
    }

    fun supplementaryCharacters() {

        //Unicode characters outside the BMP, such as emojis and some historic
        // scripts, cannot be represented by a single Char. In UTF-16, they are encoded as
        // a surrogate pair, where two Char values together represent one Unicode character
        // in a String:

    //sampleStart
        val emoji = "🥦"

        println(emoji.length) // 2
        println(emoji[0])     // First surrogate
        println(emoji[1])     // Second surrogate
    //sampleEnd
    }
}

/**
| Escape Sequence | Description                                        |
| --------------- | -------------------------------------------------- |
| `\t`            | Tab                                                |
| `\b`            | Backspace                                          |
| `\n`            | New Line (LF)                                      |
| `\r`            | Carriage Return (CR)                               |
| `\'`            | Single quotation mark                              |
| `\"`            | Double quotation mark                              |
| `\\`            | Backslash                                          |
| `\$`            | Dollar sign (used to escape `$` in Kotlin strings) |
**/


fun characterComparison(){
    val before = 'a' < 'b' // true
    val after = 'c' > 'd' // false
    val different = 'A' == 'a' // false
    val equal = 'A' == 'A' // true
}

fun characterProcessing(){
    val myChar = 'A'
// Checks if the character represents a digit
    println(myChar.isDigit()) // false
// Checks if the character represents an uppercase letter
    println(myChar.isUpperCase()) // true
// Returns a lowercase version
    println(myChar.lowercaseChar()) // 'a'
}

fun characterArithmetic(){
    /*
    You can create another character value by adding or subtracting an integer:
*/

    val a = 'a'

    println(a + 1)  // b

    println(a + 2)  // c

    println(a - 32) // A


    /** note:  These operations follow Unicode values, not language-specific alphabet rules. */


    //The increment (++) and decrement (--) operators in the prefix and postfix forms with mutable variables can be used as well

    var aA = 'A'

    aA += 10

    println(a)   // 'K'

    println(++aA) // 'L'  prefix increment

    println(aA++) // 'L'  postfix increment

    println(aA)   // 'M'


    println(--aA) // 'L'  prefix decrement

    println(aA--) // 'L'  postfix decrement

    println(aA)   // 'K'
}

fun characterConversion(){

    /*
    To convert Char to a numeric type, use explicit conversion:
     */

    /** Use .code to get the numeric Unicode value of a character: */

    val letter = 'A'

    println(letter.code) // 65


   //If a character represents a decimal digit, use digitToInt():

    val digit = '7'

    println(digit.digitToIntOrNull()) // 7
}
