package tree.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TreeNodeTest {

    @Test
    fun `should add a child`() {
        // given
        val parent = TreeNode("Beverages")

        // and
        val hot = TreeNode("Hot")
        val cold = TreeNode("Cold")

        // and
        val tea = TreeNode("Tea")
        val coffee = TreeNode("Coffee")

        // and
        val cola = TreeNode("Cola")
        val sprite = TreeNode("Sprite")

        // when
        parent.add(hot)

        // and
        parent.add(cold)

        // and
        hot.add(tea)
        hot.add(coffee)

        // and
        cold.add(cola)
        cold.add(sprite)

        // when
        val depthFirstOrder = mutableListOf<String>()
        parent.forEachDepthFirst { depthFirstOrder.add(it.value) }

        // then
        val result = depthFirstOrder.joinToString(separator = ", ")
        assertThat(result).isEqualTo("Beverages, Hot, Tea, Coffee, Cold, Cola, Sprite")
    }
}
