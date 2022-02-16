package graph

import graph.core.Edge
import graph.core.Graph
import graph.core.Vertex
import java.util.ArrayList

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

    override fun addUndirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double) {
        addDirectedEdge(source, destination, weight)
        addDirectedEdge(destination, source, weight)
    }
}
