package list

interface List<T> {

    fun add(element: T)

    fun add(index: Int, element: T)

    fun get(index: Int): T?

    fun first(): T?

    fun last(): T?

    fun set(index: Int, element: T)

    fun remove(index: Int): T?
}
