package graph

import graph.core.Edge
import graph.core.Graph
import graph.core.Vertex

class AdjacencyMatrix<T>: Graph<T> {

    private val verticies = arrayListOf<Vertex<T>>()
    private val weights = arrayListOf<ArrayList<Double?>>()

    override fun createVertex(data: T): Vertex<T> {
        val vertex = Vertex(verticies.count(), data)
        verticies.add(vertex)

        weights.forEach {
            it.add(null)
        }

        val row = ArrayList<Double?>(verticies.count())
        repeat(verticies.count()) {
            row.add(null)
        }
        weights.add(row)
        return vertex
    }

    override fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double) {
        weights[source.index][destination.index] = weight
    }

    override fun edges(source: Vertex<T>): ArrayList<Edge<T>> {
        val edges = arrayListOf<Edge<T>>()
        (0 until weights.size).forEach { column ->
            val weight = weights[source.index][column]
            if (weight != null) {
                edges.add(Edge(source, verticies[column], weight))
            }
        }
        return edges
    }

    override fun weight(source: Vertex<T>, destination: Vertex<T>): Double? =
        weights[source.index][destination.index]
}
