package stack

class FifoStack<E : Any>() : Stack<E> {
    private val storage = arrayListOf<E>()

    override fun push(element: E) {
        storage.add(element)
    }

    override fun pop(): E? {
        if (storage.size == 0) return null
        return storage.removeFirst()
    }

    fun visualise() = buildString {
        appendLine("----top----")
        storage.asReversed().forEach {
            appendLine("$it")
        }
        appendLine("-----------")
    }
}
