package list.core

data class Node<T>(var value: T, val next: Node<T>? = null)
