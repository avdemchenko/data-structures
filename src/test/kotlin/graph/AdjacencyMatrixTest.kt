package graph

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
}
