package stack

class FifoStack<E : Any> : Stack<E> {
    private val storage = arrayListOf<E>()

    override fun push(element: E) {
        storage.add(element)
    }

    override fun pop(): E? {
        if (storage.size == 0) return null
        return storage.removeFirst()
    }

    override fun peek(): E? {
        return storage.lastOrNull()
    }

    fun visualise() = buildString {
        appendLine("----top----")
        storage.asReversed().forEach {
            appendLine("$it")
        }
        appendLine("-----------")
    }

    companion object {
        fun <E : Any> create(items: Iterable<E>): FifoStack<E> {
            val stack = FifoStack<E>()
            items.forEach {
                stack.push(it)
            }
            return stack
        }
    }
}
