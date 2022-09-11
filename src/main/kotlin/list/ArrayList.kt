package list

import java.lang.System.arraycopy

class ArrayList<T : Any?> : List<T> {
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

    private fun resizeIfNecessary() {
        if (elements.size == size) {
            val array = arrayOfNulls<Any>(elements.size * 2)
            arraycopy(elements, 0, array, 0, size)
            elements = array
        }
    }

    private companion object {
        const val DEFAULT_CAPACITY = 5
    }
}
