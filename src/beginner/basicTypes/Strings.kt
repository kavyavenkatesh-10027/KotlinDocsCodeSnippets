package beginner.basicTypes

fun main(){
    declaringStringsNormally()
    declaringMultilineStrings()
    stringTemplates()
    stringOperations()
    stringConversions()
}

/**
 The String type is immutable. After you create a String object, its contents
 stay the same for the rest of its lifetime. Any operation that appears to modify
 the string actually creates a new string.
 */

fun declaringStringsNormally(){
    val name: String = "Kotlin"
    val message = "Hello, world!" // Kotlin infers String
}

fun declaringMultilineStrings(){

    val text = """
        Hello,
        Kotlin
"""

    val quote = """
        Kotlin says, "Hi".
"""

/**
    Multiline strings don't support escape sequences. Kotlin treats these characters as
    regular text.
**/

    /*
    Multiline strings preserve line breaks and indentations as written
    in the source code. This behavior is useful when you want the runtime value
     to match the text layout in your file.
    */

    //In the following example, the spaces before each line are part of the resulting string:

    val text2 = """
    Hello,
    Kotlin
"""

/**
    To remove common leading indentation, use the trimIndent() function. It detects
    the common minimal indent of non-empty lines and removes it:
**/
    val text3 = """

        Hello,

        Kotlin

    """.trimIndent()

    println("$text\n\n $text2\n\n $text3")


    /**
    To control indentation removal more explicitly, use the trimMargin() function.
    It removes everything before and including the margin prefix on each line:
     */

    val text4 = """

        |Hello,

        |Kotlin

    """.trimMargin()


    println(text4)

    /*
    By default, the trimMargin() function uses a pipe symbol (|) as the margin prefix,
     but you can pass another character as a parameter. For example: trimMargin(">").
     */

    /**
        note :   When you process a string with functions like trimIndent() or
        trimMargin(), the resulting string uses only newline (\n) separators,
        regardless of the platform.
    */
}

fun stringTemplates() {
    val name = "Kotlin"
    println("Hello, $name")
// Hello, Kotlin

    /**
    interpolation. You can use string templates in both regular and multiline strings.
     */

    /*
    To insert an expression into a string or to place a variable directly next to other text,
     use ${}:
     */

    val text = "abc"
    println("The length of $text is ${text.length}")
// The length of abc is 3

    val language = "Kotlin"
    println("${language}Lang")
// KotlinLang

    //+ can we used to concat various strings but readability will be sacrificed

// Double-quoted string
    val test = "${"test".uppercase()}"

// Multiline string
    val result = """
    Result: ${"OK".lowercase()}
    """

//Nullable values in string
    val message: String? = null

    println("Hello, $message")
// Hello, null

    println("Hello, ${text ?: "Kotlin"}")
// Hello, Kotlin


// Multi-dollar string interpolation

    /*
    In regular string templates, a single dollar sign ($) starts string interpolation.
    If you need to include literal dollar signs in a string, you can use
    multi-dollar string interpolation.
    */

    /**
    Multi-dollar string interpolation lets you specify how many consecutive
    dollar signs are required to start interpolation.

    Any sequence of dollar signs shorter than that is treated as a literal
    part of the string.
    **/

// For example, if you use $$ before a string literal, interpolation
// begins only when two consecutive dollar signs ($$) appear.

/*
    val name2 = "Alice"

    val text2 = $$"""
    Price: $100
    Hello, $$name2
    """.trimIndent()

    println(text2)
*/
    /**
    multi_dollar_interpolation must be enabled
    */

// A single $ inside the string is treated as a literal dollar sign
// and does not start interpolation.
}

fun stringOperations(){

//LENGTH
    val language = "Kotlin"
    println(language.length)

//ACCESSING CHARACTERS
    println(language[0])
    println(language[5])

    /**
    A string index starts at zero. If you try to access an index outside the valid range,
    Kotlin throws an exception[StringIndexOutOfBoundsException].
    **/

//ITERATION over string, CHAR -> String
    for (char in "Kotlin") {
        println(char)
    }


//EXTRACTION
/**
    substring() to return a new string with the selected part of the original text.

    subSequence() to return a CharSequence with the selected part of the original text.
**/

    val text = "Kotlin"

    println(text.substring(1))
    println(text.substring(1, 5))//always returns string
    println(text.subSequence(1, 5))//interface


  /**
   * note : Since the String type is immutable, these functions don't modify the
   *  original string.
   **/


//STRING COMPARISON
    println("kotlin" == "kotlin") // true
    println("kotlin" == "Kotlin") // false
/**
    == is case-sensitive
*/

    /*
    Strings can also be compared lexicographically (character by character) with
    the compareTo() function. It scans both strings until it finds the first differing
    pair of characters and returns:

    0 when the strings are equal.

    A value less than 0 when the receiver is smaller than the argument.

    A value greater than 0 when the receiver is greater than the argument.
     */

    println("abc".compareTo("abd") < 0) // true

    println("abc".compareTo("ABC") > 0) // true

    println("abc".compareTo("ABC", ignoreCase = true) == 0) // true
    /**
        Pass true to ignore case differences
     */

//WORKING WITH STRINGS(Editing)
    val testCase = "  Hello, Kotlin  "

    println(testCase.trim())

    println(testCase.replace("Kotlin", "world"))

    println(testCase.uppercase())

    println(testCase.lowercase())

    //inspection
    val domain = "kavyavenkatesh@gmail.com"
// Checks if the string contains "."
    println(domain.contains("."))

// Checks if the string starts with "kotlin"
    println(domain.startsWith("yaven"))

// Checks if the string ends with ".org"
    println(domain.endsWith(".com"))


//SPLIT STRING

    //split('$delimiter') function:

    val numero = "one, two, three"

    println(numero.split(", "))

// [one, two, three]

    //lines() function = split('\n') same result:

    val numbers = "one\ntwo\nthree"

    println(numbers.lines())

// [one, two, three]


//BUILD STRING

/**
    Why not just use +?
    Because every + creates a new string which is not efficient. Therefore, we can use
    buildString(), or String Buffer class which return a string after all the operations
 */

val hasErrors = true
    val hasWarnings = true
    val isComplete = false

// buildString creates an empty buffer
    val status = buildString {
        // Appends "Errors found" to the buffer
        if (hasErrors) append("Errors found")
        if (hasWarnings) {
            // The buffer is not empty, appends "; "
            if (isNotEmpty()) append("; ")
            // Appends "Warnings found"
            append("Warnings found")
        }
        // isComplete = false, nothing to append
        if (isComplete) {
            if (isNotEmpty()) append("; ")
            append("Completed")
        }
        // The buffer is not empty, skips the fallback
        if (isEmpty()) append("OK")
    }

    println(status)
// Errors found; Warnings found

/*
    Use StringBuffer, if you want to edit an existing value.
 */
    val textSample = "Hello, Kotlin"
    val builder = StringBuilder(textSample)

    builder.replace(7, 13 , "world")
    println(builder.toString()) //Hello, world

//FORMAT (JVM only)
    val textFormatted = String.format("Hello, %s", "Kotlin")
    println(textFormatted)
}

fun stringConversions(){
    val toInt = "10".toInt() // 10

// 1000000000000 exceeds maximum value of Int
    val toIntInvalid = "1000000000000".toIntOrNull()

    val toBoolean = "true".toBooleanStrict() // true
    val toBooleanInvalid = "yes".toBooleanStrictOrNull() // null

    /**
     To convert a string to another type, use the corresponding parsing functions:

          For integer values: toByte(), toShort(), toInt(), toLong()

          For floating-point values: toDouble(), toFloat()

          For booleans: toBoolean(), toBooleanStrict()
     */
}