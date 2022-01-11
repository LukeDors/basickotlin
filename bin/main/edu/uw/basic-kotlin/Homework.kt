package edu.uw.basickotlin

class Library {
    // This is just here as a placeholder, to make sure tests run and pass
    // before you add any code
    fun someLibraryMethod(): Boolean {
        return true
    }
}

fun whenFn(x: Any): String {
    var str = ""
    when (x) {
        "Hello" -> str = "world"
        is String -> str = "Say what?"
        0 -> str = "zero"
        1 -> str = "one"
        in 2..10 -> str = "low number"
        is Int -> str = "a number"
        else -> str = "I don't understand"
    }
    return str
}

fun add(a: Int, b: Int): Int {
    return a + b
}

fun sub(a: Int, b: Int): Int {
    return a - b
}

// write a "mathOp" function that takes two Ints and a function (that takes two Ints and returns an Int), returns an Int, and applies the passed-in-function to the arguments
fun mathOp(a: Int, b: Int, funct: (x: Int, y: Int) -> Int): Int {
    return funct(a, b)
}

class Person(var firstName: String, val lastName: String, var age: Int) {
    val debugString = "[Person firstName:${firstName} lastName:${lastName} age:${age}]"
} 
// write a class "Money" with amount and currency, and define a convert() method and the "+" operator
class Money(val amount: Int, val currency: String) {
    init {
        if (amount < 0) {
            throw IllegalArgumentException ("Amount cannot be less than 0")
        }
        if (currency != "USD" && currency != "GBP" && currency != "EUR" && currency != "CAN") {
            throw IllegalArgumentException ("Invalid currency")
        }
    }
    operator fun plus(other: Money): Money {
        if (this.currency != other.currency) {
            var newMoney = other.convert(currency)
            return Money(this.amount + newMoney.amount, this.currency)
        } else {
            return Money(this.amount + other.amount, this.currency)
        }
    }
    
    fun convert (newCurrency: String): Money {
        var newAmount = 0.0
        if (this.currency == "USD") {
            when (newCurrency) {
                "USD" -> newAmount = amount * 1.0
                "GBP" -> newAmount = amount / 2.0
                "EUR" -> newAmount = amount * 1.5
                "CAN" -> newAmount = amount * 1.25
            }
        } else if (this.currency == "GBP") {
            when (newCurrency) {
                "GBP" -> newAmount = amount * 1.0
                "USD" -> newAmount = amount * 2.0
                "EUR" -> newAmount = amount * 3.0
                "CAN" -> newAmount = amount * 2.5
            }
        } else if (this.currency == "CAN") {
            when (newCurrency) {
                "CAN" -> newAmount = amount * 1.0
                "GBP" -> newAmount = amount / 2.5
                "EUR" -> newAmount = amount * 1.2
                "USD" -> newAmount = amount / 1.25
            }
        } else if (this.currency == "EUR") {
            when (newCurrency) {
                "EUR" -> newAmount = amount * 1.0
                "GBP" -> newAmount = amount / 3.0
                "USD" -> newAmount = amount / 1.5
                "CAN" -> newAmount = amount / 1.2
            }
        }
        return Money(newAmount.toInt(), newCurrency) 
    }
}