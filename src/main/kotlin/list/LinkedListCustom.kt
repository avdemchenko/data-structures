package list

import list.core.Node

class LinkedListCustom<T> : List<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size: Int = 0

    override fun add(element: T) {
        if (head?.next == null) {
            head = Node(element)
            tail = head
        } else {
            tail?.next = Node(element)
        }
        size++
    }

    override fun add(index: Int, element: T) {
        TODO("Not yet implemented")
    }

    override fun get(index: Int): T? {
        TODO("Not yet implemented")
    }

    override fun first(): T? {
        TODO("Not yet implemented")
    }

    override fun last(): T? {
        TODO("Not yet implemented")
    }

    override fun set(index: Int, element: T) {
        TODO("Not yet implemented")
    }

    override fun remove(index: Int): T? {
        TODO("Not yet implemented")
    }

    override fun contains(element: T): Boolean {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean = size == 0

    override fun size(): Int = size

    override fun clear() {
        TODO("Not yet implemented")
    }

    fun visualise() = buildString {
        appendLine("----LinkedList----")
        appendLine("HEAD: " + head?.value)
        while (head?.next != null) {
            append(" --->" + head?.next)
        }
        appendLine("\n----------------")
    }
}
