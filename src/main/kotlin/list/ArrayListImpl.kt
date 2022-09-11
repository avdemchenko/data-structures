package list

import java.lang.System.arraycopy

class ArrayListImpl<T : Any> : List<T> {
    private var elements: Array<Any?> = arrayOfNulls(DEFAULT_CAPACITY)
    private var size: Int = 0

    override fun add(element: T) {
        if (elements.size == size) {
            val array = arrayOfNulls<Any>(elements.size * 2)
            arraycopy(elements, 0, array, 0, size)
            elements = array
        }
        elements[size] = element
        size++
    }

    private companion object {
        val DEFAULT_CAPACITY = 5
    }
}
