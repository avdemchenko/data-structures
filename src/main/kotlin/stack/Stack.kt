package stack

interface Stack<E> {

    fun push(element: E)

    fun pop(): E?

    fun peek(): E?
}
