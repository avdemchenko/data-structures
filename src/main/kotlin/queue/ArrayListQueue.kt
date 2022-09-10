package queue

class ArrayListQueue<T> : Queue<T> {

    private val list = arrayListOf<T>()

    override fun enqueue(element: T): Boolean = list.add(element)

    override fun dequeue(): T? = list.removeFirstOrNull()

    override val isEmpty: Boolean = list.size == 0

    override fun peek(): T? = list.firstOrNull()

    fun visualise() = buildString {
        appendLine("----Queue----")
        list.forEach { append(" $it") }
        appendLine("\n-------------")
    }
}
