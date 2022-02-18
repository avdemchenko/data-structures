package graph.core

import graph.core.EdgeType.DIRECTED
import graph.core.EdgeType.UNDIRECTED

interface Graph<T> {

    fun createVertex(data: T): Vertex<T>

    fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double)

    fun addUndirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double) {
        addDirectedEdge(source, destination, weight)
        addDirectedEdge(destination, source, weight)
    }

    fun add(edgeType: EdgeType, source: Vertex<T>, destination: Vertex<T>, weight: Double) {
        when (edgeType) {
            DIRECTED -> addDirectedEdge(source, destination, weight)
            UNDIRECTED -> addUndirectedEdge(source, destination, weight)
        }
    }

    fun edges(source: Vertex<T>): ArrayList<Edge<T>>

    fun weight(source: Vertex<T>, destination: Vertex<T>): Double?
}
