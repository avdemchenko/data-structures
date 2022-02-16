package graph.core

interface Graph<T> {
    fun createVertex(data: T): Vertex<T>
}
