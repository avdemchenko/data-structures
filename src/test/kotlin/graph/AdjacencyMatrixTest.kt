package graph

import graph.core.EdgeType.DIRECTED
import graph.core.EdgeType.UNDIRECTED
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AdjacencyMatrixTest {

    @Test
    fun `should create vertex`() {
        // given
        val adjacencyMatrix = AdjacencyMatrix<String>()

        // when
        val firstVertex = adjacencyMatrix.createVertex("first value")
        val secondVertex = adjacencyMatrix.createVertex("last value")

        // then
        assertThat(firstVertex.index).isEqualTo(0)
        assertThat(firstVertex.data).isEqualTo("first value")

        // and
        assertThat(secondVertex.index).isEqualTo(1)
        assertThat(secondVertex.data).isEqualTo("last value")
    }

    @Test
    fun `should add directed edge`() {
        // given
        val adjacencyMatrix = AdjacencyMatrix<String>()

        // when
        val firstVertex = adjacencyMatrix.createVertex("first value")
        val secondVertex = adjacencyMatrix.createVertex("last value")

        // and
        adjacencyMatrix.addDirectedEdge(firstVertex, secondVertex, 1.0)

        // then
        val firstVertexEdges = adjacencyMatrix.edges(firstVertex)
        assertThat(firstVertexEdges.size).isEqualTo(1)

        // and
        val firstVertexEdge = firstVertexEdges.first()
        assertThat(firstVertexEdge.source).isEqualTo(firstVertex)
        assertThat(firstVertexEdge.destination).isEqualTo(secondVertex)
        assertThat(firstVertexEdge.weight).isEqualTo(1.0)

        // and
        val secondVertexEdges = adjacencyMatrix.edges(secondVertex)
        assertThat(secondVertexEdges.size).isEqualTo(0)
    }

    @Test
    fun `should add directed edge by type`() {
        // given
        val adjacencyMatrix = AdjacencyMatrix<String>()

        // when
        val firstVertex = adjacencyMatrix.createVertex("first value")
        val secondVertex = adjacencyMatrix.createVertex("last value")

        // and
        adjacencyMatrix.add(DIRECTED, firstVertex, secondVertex, 1.0)

        // then
        val firstVertexEdges = adjacencyMatrix.edges(firstVertex)
        assertThat(firstVertexEdges.size).isEqualTo(1)

        // and
        val firstVertexEdge = firstVertexEdges.first()
        assertThat(firstVertexEdge.source).isEqualTo(firstVertex)
        assertThat(firstVertexEdge.destination).isEqualTo(secondVertex)
        assertThat(firstVertexEdge.weight).isEqualTo(1.0)

        // and
        val secondVertexEdges = adjacencyMatrix.edges(secondVertex)
        assertThat(secondVertexEdges.size).isEqualTo(0)
    }

    @Test
    fun `should add undirected edge`() {
        // given
        val adjacencyMatrix = AdjacencyMatrix<String>()

        // when
        val firstVertex = adjacencyMatrix.createVertex("first value")
        val secondVertex = adjacencyMatrix.createVertex("last value")

        // and
        adjacencyMatrix.addUndirectedEdge(firstVertex, secondVertex, 1.0)

        // then
        val firstVertexEdges = adjacencyMatrix.edges(firstVertex)
        assertThat(firstVertexEdges.size).isEqualTo(1)

        // and
        val firstVertexEdge = firstVertexEdges.first()
        assertThat(firstVertexEdge.source).isEqualTo(firstVertex)
        assertThat(firstVertexEdge.destination).isEqualTo(secondVertex)
        assertThat(firstVertexEdge.weight).isEqualTo(1.0)

        // and
        val secondVertexEdges = adjacencyMatrix.edges(secondVertex)
        assertThat(secondVertexEdges.size).isEqualTo(1)

        // and
        val secondVertexEdge = secondVertexEdges.first()
        assertThat(secondVertexEdge.source).isEqualTo(secondVertex)
        assertThat(secondVertexEdge.destination).isEqualTo(firstVertex)
        assertThat(secondVertexEdge.weight).isEqualTo(1.0)
    }

    @Test
    fun `should add undirected edge by type`() {
        // given
        val adjacencyMatrix = AdjacencyMatrix<String>()

        // when
        val firstVertex = adjacencyMatrix.createVertex("first value")
        val secondVertex = adjacencyMatrix.createVertex("last value")

        // and
        adjacencyMatrix.add(UNDIRECTED, firstVertex, secondVertex, 1.0)

        // then
        val firstVertexEdges = adjacencyMatrix.edges(firstVertex)
        assertThat(firstVertexEdges.size).isEqualTo(1)

        // and
        val firstVertexEdge = firstVertexEdges.first()
        assertThat(firstVertexEdge.source).isEqualTo(firstVertex)
        assertThat(firstVertexEdge.destination).isEqualTo(secondVertex)
        assertThat(firstVertexEdge.weight).isEqualTo(1.0)

        // and
        val secondVertexEdges = adjacencyMatrix.edges(secondVertex)
        assertThat(secondVertexEdges.size).isEqualTo(1)

        // and
        val secondVertexEdge = secondVertexEdges.first()
        assertThat(secondVertexEdge.source).isEqualTo(secondVertex)
        assertThat(secondVertexEdge.destination).isEqualTo(firstVertex)
        assertThat(secondVertexEdge.weight).isEqualTo(1.0)
    }
}
