package queue

fun main() {
    showQueue()
}

fun showQueue() {
    val queue = ArrayListQueue<String>()

    queue.enqueue("First")
    queue.enqueue("Second")
    queue.enqueue("Third")

    println(queue.visualise())

    println("Removed: " + queue.dequeue())
    println("Removed: " + queue.dequeue())
    println("Removed: " + queue.dequeue())
    println("Removed: " + queue.dequeue())
}
