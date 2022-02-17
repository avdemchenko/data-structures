package graph

import graph.core.EdgeType.DIRECTED
import graph.core.EdgeType.UNDIRECTED
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AdjacencyListTest {

    @Test
    fun `should create vertex`() {
        // given
        val adjacencyList = AdjacencyList<String>()

        // when
        val firstVertex = adjacencyList.createVertex("first value")
        val secondVertex = adjacencyList.createVertex("last value")

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
        val adjacencyList = AdjacencyList<String>()

        // when
        val firstVertex = adjacencyList.createVertex("first value")
        val secondVertex = adjacencyList.createVertex("last value")

        // and
        adjacencyList.addDirectedEdge(firstVertex, secondVertex, 1.0)

        // then
        val firstVertexEdges = adjacencyList.edges(firstVertex)
        assertThat(firstVertexEdges.size).isEqualTo(1)

        // and
        val firstVertexEdge = firstVertexEdges.first()
        assertThat(firstVertexEdge.source).isEqualTo(firstVertex)
        assertThat(firstVertexEdge.destination).isEqualTo(secondVertex)
        assertThat(firstVertexEdge.weight).isEqualTo(1.0)

        // and
        val secondVertexEdges = adjacencyList.edges(secondVertex)
        assertThat(secondVertexEdges.size).isEqualTo(0)
    }

    @Test
    fun `should add directed edge by type`() {
        // given
        val adjacencyList = AdjacencyList<String>()

        // when
        val firstVertex = adjacencyList.createVertex("first value")
        val secondVertex = adjacencyList.createVertex("last value")

        // and
        adjacencyList.add(DIRECTED, firstVertex, secondVertex, 1.0)

        // then
        val firstVertexEdges = adjacencyList.edges(firstVertex)
        assertThat(firstVertexEdges.size).isEqualTo(1)

        // and
        val firstVertexEdge = firstVertexEdges.first()
        assertThat(firstVertexEdge.source).isEqualTo(firstVertex)
        assertThat(firstVertexEdge.destination).isEqualTo(secondVertex)
        assertThat(firstVertexEdge.weight).isEqualTo(1.0)

        // and
        val secondVertexEdges = adjacencyList.edges(secondVertex)
        assertThat(secondVertexEdges.size).isEqualTo(0)
    }

    @Test
    fun `should add undirected edge`() {
        // given
        val adjacencyList = AdjacencyList<String>()

        // when
        val firstVertex = adjacencyList.createVertex("first value")
        val secondVertex = adjacencyList.createVertex("last value")

        // and
        adjacencyList.addUndirectedEdge(firstVertex, secondVertex, 1.0)

        // then
        val firstVertexEdges = adjacencyList.edges(firstVertex)
        assertThat(firstVertexEdges.size).isEqualTo(1)

        // and
        val firstVertexEdge = firstVertexEdges.first()
        assertThat(firstVertexEdge.source).isEqualTo(firstVertex)
        assertThat(firstVertexEdge.destination).isEqualTo(secondVertex)
        assertThat(firstVertexEdge.weight).isEqualTo(1.0)

        // and
        val secondVertexEdges = adjacencyList.edges(secondVertex)
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
        val adjacencyList = AdjacencyList<String>()

        // when
        val firstVertex = adjacencyList.createVertex("first value")
        val secondVertex = adjacencyList.createVertex("last value")

        // and
        adjacencyList.add(UNDIRECTED, firstVertex, secondVertex, 1.0)

        // then
        val firstVertexEdges = adjacencyList.edges(firstVertex)
        assertThat(firstVertexEdges.size).isEqualTo(1)

        // and
        val firstVertexEdge = firstVertexEdges.first()
        assertThat(firstVertexEdge.source).isEqualTo(firstVertex)
        assertThat(firstVertexEdge.destination).isEqualTo(secondVertex)
        assertThat(firstVertexEdge.weight).isEqualTo(1.0)

        // and
        val secondVertexEdges = adjacencyList.edges(secondVertex)
        assertThat(secondVertexEdges.size).isEqualTo(1)

        // and
        val secondVertexEdge = secondVertexEdges.first()
        assertThat(secondVertexEdge.source).isEqualTo(secondVertex)
        assertThat(secondVertexEdge.destination).isEqualTo(firstVertex)
        assertThat(secondVertexEdge.weight).isEqualTo(1.0)
    }

    @Test
    fun `should get weight of the directed edge`() {
        // given
        val adjacencyList = AdjacencyList<String>()

        // when
        val firstVertex = adjacencyList.createVertex("first value")
        val secondVertex = adjacencyList.createVertex("last value")

        // and
        adjacencyList.add(DIRECTED, firstVertex, secondVertex, 1.0)

        // then
        val directWeight = adjacencyList.weight(firstVertex, secondVertex)
        assertThat(directWeight).isEqualTo(1.0)

        // and
        val reversedWeight = adjacencyList.weight(secondVertex, firstVertex)
        assertThat(reversedWeight).isNull()
    }

    @Test
    fun `should get weight of the undirected edge`() {
        // given
        val adjacencyList = AdjacencyList<String>()

        // when
        val firstVertex = adjacencyList.createVertex("first value")
        val secondVertex = adjacencyList.createVertex("last value")

        // and
        adjacencyList.add(UNDIRECTED, firstVertex, secondVertex, 1.0)

        // then
        val directWeight = adjacencyList.weight(firstVertex, secondVertex)
        assertThat(directWeight).isEqualTo(1.0)

        // and
        val reversedWeight = adjacencyList.weight(secondVertex, firstVertex)
        assertThat(reversedWeight).isEqualTo(1.0)
    }
}
