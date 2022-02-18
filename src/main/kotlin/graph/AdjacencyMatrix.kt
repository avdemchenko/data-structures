package graph

import graph.core.Edge
import graph.core.EdgeType
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
        TODO("Not yet implemented")
    }

    override fun addUndirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double) {
        TODO("Not yet implemented")
    }

    override fun add(edgeType: EdgeType, source: Vertex<T>, destination: Vertex<T>, weight: Double) {
        TODO("Not yet implemented")
    }

    override fun edges(source: Vertex<T>): ArrayList<Edge<T>> {
        TODO("Not yet implemented")
    }

    override fun weight(source: Vertex<T>, destination: Vertex<T>): Double? {
        TODO("Not yet implemented")
    }
}
