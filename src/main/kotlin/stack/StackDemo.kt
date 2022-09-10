package stack

fun main() {
    showLifoStack()
    showFifoStack()
}

fun showLifoStack() {
    val stack = LifoStack<String>()

    stack.push("First")
    stack.push("Second")
    stack.push("Third")

    println("LIFO stack:\n" + stack.visualise())
    println("Popped: " + stack.pop())
    println("Popped: " + stack.pop())
    println("Popped: " + stack.pop())
    println()
}

fun showFifoStack() {
    val stack = FifoStack<String>()

    stack.push("First")
    stack.push("Second")
    stack.push("Third")

    println("FIFO stack:\n" + stack.visualise())
    println("Popped: " + stack.pop())
    println("Popped: " + stack.pop())
    println("Popped: " + stack.pop())
    println()
}
