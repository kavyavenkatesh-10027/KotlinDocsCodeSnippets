package beginner.helloWorld

//val cannot be re-assigned, but the object store can be mutated
//var can be reassigned

fun main(){
    val popcorn = 5
    val burger = 7
    var customers = 10

    // Some customers leave the queue
    customers = 8
    println(customers)
}

/**
    All variables should be declared as read-only (val) only, unless necessary,
    in which case mutable variable(var) is used
 */

