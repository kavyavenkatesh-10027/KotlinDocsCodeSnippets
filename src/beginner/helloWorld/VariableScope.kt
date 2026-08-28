package beginner.helloWorld

/**
| Type                      | Declared Where                    | Belongs To                          | Lifetime                       |
| ------------------------- | --------------------------------- | ----------------------------------- | ------------------------------ |
| Top-level                 | Outside classes/functions         | File                                | Entire program                 |
| Local                     | Inside function/block             | Function/block                      | Until block ends               |
| Member property           | Inside class                      | Object                              | As long as object exists       |
| Constructor property      | Primary constructor (`val`/`var`) | Object                              | As long as object exists       |
| Companion object property | Inside `companion object`         | Class (shared)                      | Entire program                 |
| Object property           | Inside `object`                   | Singleton                           | Entire program                 |
| Extension property        | Outside class                     | Existing type (syntactic extension) | No storage; computed on access |
**/

val PI = 3.14159

fun main() {
    println(PI)
}
/**
A. Top-level variables
-Belong to the file, not to any class.
-Accessible from other files (depending on visibility modifiers like public, private, internal).
-Compiled as static fields in a generated Java class (e.g., FileNameKt).
-Often used for:
    1.constants
    2.utility values
    3.configuration
 **/



fun greet() {
    val name = "Alice"
    println(name)
}
/**
B. Local variables
-Exist only while the function/block executes.
-Cannot be accessed outside their scope.
-Stored on the stack (in most JVM cases).
 **/



class Car {
    var speed = 0
}
/*
val c1 = Car()
val c2 = Car()

c1.speed = 50
c2.speed = 80
 */
/**
C. Member properties
-Belong to each object.
-Every object gets its own copy.
 **/



class Student(
    val name: String,
    var age: Int
)
/**
D. Constructor properties (Shorter syntax to member property)
-Declared directly in the primary constructor using val or var
 **/



class MathUtil {
    companion object {
        val VERSION = "1.0"
    }
}
/*
println(MathUtil.VERSION)
 */
/**
E. Companion Object properties
-One copy shared by all objects.
-Kotlin's replacement for many Java static fields.
 **/



object Database {
    var connected = false
}
/**
F. Object properties(Singleton)
-Only one instance of the object exists
-One object is shared across the entire application
 **/



val String.lastChar: Char
    get() = this[length - 1]
/*
println("Hello".lastChar)
 */
/**
G. Extension properties
-Kotlin lets you define a property for an existing type.
-It does not have backing fields and value must be computed
 from the logic inside getter
 */