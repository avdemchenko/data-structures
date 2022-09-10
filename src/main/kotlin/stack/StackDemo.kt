package stack

import java.util.LinkedList

fun main() {
    showLifoStack()
    showFifoStack()
    reverseLinkedList()
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

    val stackFromList = LifoStack.create(listOf(1, 2, 3))
    println("LIFO stack from list:\n" + stackFromList.visualise())
    println("Popped: " + stackFromList.pop())
    println("Popped: " + stackFromList.pop())
    println("Popped: " + stackFromList.pop())
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

    val stackFromList = FifoStack.create(listOf(1, 2, 3))
    println("FIFO stack from list:\n" + stackFromList.visualise())
    println("Popped: " + stackFromList.pop())
    println("Popped: " + stackFromList.pop())
    println("Popped: " + stackFromList.pop())
    println()
}

fun reverseLinkedList() {
    var list = LinkedList(listOf(1, 2, 3, 4))
    val stack = LifoStack<Int>()

    list.forEach { stack.push(it) }

    println("Reversed LinkedList with LIFO stack:\n" + stack.visualise())
}
