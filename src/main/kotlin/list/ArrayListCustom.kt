package list

import java.lang.System.arraycopy

class ArrayListCustom<T : Any?> : List<T> {
    private var elements: Array<Any?> = arrayOfNulls(DEFAULT_CAPACITY)
    private var size: Int = 0

    override fun add(element: T) {
        resizeIfNecessary()
        elements[size] = element
        size++
    }

    override fun add(index: Int, element: T) {
        if (index in elements.indices) {
            resizeIfNecessary()
            arraycopy(elements, index, elements, index + 1, size - index)
            elements[index] = element
        } else throw ArrayIndexOutOfBoundsException()
    }

    @Suppress("UNCHECKED_CAST")
    override fun get(index: Int): T? {
        if (index in elements.indices) return elements[index] as T
        else throw ArrayIndexOutOfBoundsException()
    }

    @Suppress("UNCHECKED_CAST")
    override fun first(): T? {
        return elements.first() as T
    }

    @Suppress("UNCHECKED_CAST")
    override fun last(): T? {
        return elements[elements.size - 1] as T
    }

    override fun set(index: Int, element: T) {
        if (index in elements.indices) elements[index] = element
        else throw ArrayIndexOutOfBoundsException()
    }

    @Suppress("UNCHECKED_CAST")
    override fun remove(index: Int): T? {
        if (index in elements.indices) {
            val removedElement = elements[index] as T
            arraycopy(elements, index + 1, elements, index, elements.size - index - 1)
            return removedElement
        } else throw ArrayIndexOutOfBoundsException()
    }

    override fun contains(element: T): Boolean {
        for (i in elements.indices) {
            if (elements[i] == element) return true
        }
        return false
    }

    override fun size(): Int = size

    override fun isEmpty(): Boolean = size == 0

    override fun clear() {
        size = 0
        elements = arrayOfNulls(DEFAULT_CAPACITY)
    }

    private fun resizeIfNecessary() {
        if (elements.size == size) {
            val array = arrayOfNulls<Any>(elements.size * 2)
            arraycopy(elements, 0, array, 0, size)
            elements = array
        }
    }

    fun visualise() = buildString {
        appendLine("----ArrayList----")
        elements.forEach { append(" $it") }
        appendLine("\n---------------")
    }

    private companion object {
        const val DEFAULT_CAPACITY = 5
    }
}
