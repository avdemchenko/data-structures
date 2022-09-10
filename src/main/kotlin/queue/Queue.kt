package queue

interface Queue<T> {

    fun enqueue(element: T): Boolean

    fun dequeue(): T?

    val isEmpty: Boolean

    fun peek(): T?
}
