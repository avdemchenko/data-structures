package graph.exception

data class NoSuchVertexException(val index: Int) : IllegalArgumentException("Vertex with index $index not found")
