package tree.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TreeNodeTest {

    @Test
    fun `should depth first traversal`() {
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

    @Test
    fun `should level order traversal`() {
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
        parent.forEachLevelOrder { depthFirstOrder.add(it.value) }

        // then
        val result = depthFirstOrder.joinToString(separator = ", ")
        assertThat(result).isEqualTo("Beverages, Hot, Cold, Tea, Coffee, Cola, Sprite")
    }

    @Test
    fun `should search element`() {
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

        // then
        val result = parent.search("Cola")
        assertThat(result).isNotNull

        // and
        assertThat(result?.value).isEqualTo("Cola")
    }
}
