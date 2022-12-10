package list

import java.lang.System.arraycopy

class ArrayListCustom<T : Any?> {
    private var elements: Array<Any?> = arrayOfNulls(DEFAULT_CAPACITY)
    private var size: Int = 0

    fun add(element: T) {
        resizeIfNecessary()
        elements[size] = element
        size++
    }

    fun add(index: Int, element: T) {
        if (index in elements.indices) {
            resizeIfNecessary()
            arraycopy(elements, index, elements, index + 1, size - index)
            elements[index] = element
        } else throw ArrayIndexOutOfBoundsException()
    }

    @Suppress("UNCHECKED_CAST")
    fun get(index: Int): T? {
        if (index in elements.indices) return elements[index] as T
        else throw ArrayIndexOutOfBoundsException()
    }

    @Suppress("UNCHECKED_CAST")
    fun first(): T? {
        return elements.first() as T
    }

    @Suppress("UNCHECKED_CAST")
    fun last(): T? {
        return elements[elements.size - 1] as T
    }

    fun set(index: Int, element: T) {
        if (index in elements.indices) elements[index] = element
        else throw ArrayIndexOutOfBoundsException()
    }

    @Suppress("UNCHECKED_CAST")
    fun remove(index: Int): T? {
        if (index in elements.indices) {
            val removedElement = elements[index] as T
            arraycopy(elements, index + 1, elements, index, elements.size - index - 1)
            return removedElement
        } else throw ArrayIndexOutOfBoundsException()
    }

    fun contains(element: T): Boolean {
        for (i in elements.indices) {
            if (elements[i] == element) return true
        }
        return false
    }

    fun size(): Int = size

    fun isEmpty(): Boolean = size == 0

    fun clear() {
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
