package graph

import graph.core.Edge
import graph.core.EdgeType
import graph.core.EdgeType.DIRECTED
import graph.core.EdgeType.UNDIRECTED
import graph.core.Graph
import graph.core.Vertex

class AdjacencyList<T> : Graph<T> {
    private val adjacencies = HashMap<Vertex<T>, ArrayList<Edge<T>>>()

    override fun createVertex(data: T): Vertex<T> {
        val vertex = Vertex(adjacencies.count(), data)
        adjacencies[vertex] = ArrayList()
        return vertex
    }

    override fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double) {
        val edge = Edge(source, destination, weight)
        adjacencies[source]?.add(edge)
    }

    override fun edges(source: Vertex<T>) = adjacencies[source] ?: arrayListOf()

    override fun weight(source: Vertex<T>, destination: Vertex<T>): Double? {
        return edges(source).firstOrNull { it.destination == destination }?.weight
    }

    fun visualise() =
        buildString {
            adjacencies.forEach { (vertex, edges) ->
                val edge = edges.joinToString { it.destination.data.toString() }
                append("${vertex.data} ====> [$edge]\n")
            }
        }
}
