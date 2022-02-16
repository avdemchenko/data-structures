package graph.core

interface Graph<T> {

    fun createVertex(data: T): Vertex<T>
    fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double)
    fun addUndirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double)
    fun add(edgeType: EdgeType, source: Vertex<T>, destination: Vertex<T>, weight: Double)
    fun edges(source: Vertex<T>): ArrayList<Edge<T>>
}
