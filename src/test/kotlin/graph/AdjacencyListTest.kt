package graph

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
}
