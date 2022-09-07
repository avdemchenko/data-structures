package graph

import graph.core.Edge
import graph.core.Graph
import graph.core.Vertex

class AdjacencyMatrix<T> : Graph<T> {

    private val vertices = arrayListOf<Vertex<T>>()
    private val weights = arrayListOf<ArrayList<Double?>>()

    override fun createVertex(data: T): Vertex<T> {
        val vertex = Vertex(vertices.count(), data)
        vertices.add(vertex)
        weights.forEach {
            it.add(null)
        }
        val row = ArrayList<Double?>(vertices.count())
        repeat(vertices.count()) {
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
                edges.add(Edge(source, vertices[column], weight))
            }
        }
        return edges
    }

    override fun weight(source: Vertex<T>, destination: Vertex<T>): Double? =
        weights[source.index][destination.index]

    fun visualise(): String {
        val verticesDescription = vertices.joinToString(separator = "\n") { "${it.index}: ${it.data}" }
        val verticesHeader = buildString {
            append("\t\t")
            (0 until weights.size).forEach { index -> append("$index\t\t\t") }
        }

        val grid = weights.mapIndexed { index, row ->
            buildString {
                append("$index\t\t")
                (0 until weights.size).forEach { columnIndex ->
                    val value = row[columnIndex]
                    if (value != null) {
                        append("$value\t\t")
                    } else {
                        append("0\t\t\t")
                    }
                }
            }
        }
        val edgesDescription = grid.joinToString("\n")
        return "$verticesDescription\n\n$verticesHeader\n\n$edgesDescription"
    }
}
