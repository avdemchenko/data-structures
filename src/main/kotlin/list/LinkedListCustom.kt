package list

import list.core.Node

class LinkedListCustom<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size: Int = 0

    fun add(element: T) {
        val node = Node(element)
        if (size == 0) {
            head = node
            tail = head
        } else {
            tail?.next = node
            tail = node
        }
        size++
    }

    fun add(index: Int, element: T) {
        TODO("Not yet implemented")
    }

    fun get(index: Int): T? {
        TODO("Not yet implemented")
    }

    fun first(): T? {
        TODO("Not yet implemented")
    }

    fun last(): T? {
        TODO("Not yet implemented")
    }

    fun set(index: Int, element: T) {
        TODO("Not yet implemented")
    }

    fun remove(index: Int): T? {
        TODO("Not yet implemented")
    }

    fun contains(element: T): Boolean {
        TODO("Not yet implemented")
    }

    fun isEmpty(): Boolean = size == 0

    fun size(): Int = size

    fun clear() {
        TODO("Not yet implemented")
    }

    fun visualise() = buildString {
        appendLine("----LinkedList----")
        appendLine("HEAD: " + head?.value)
        var node = head
        while (node != null) {
            append(" ---> ${node.value}")
            node = node.next
        }
        appendLine("\nTAIL: " + tail?.value)
        appendLine("\n----------------")
    }
}
