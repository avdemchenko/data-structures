package tree.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BinaryNodeTest {

    @Test
    fun `should traverse in order`() {
        // given
        val zero = BinaryNode(0)
        val one = BinaryNode(1)
        val five = BinaryNode(5)
        val seven = BinaryNode(7)
        val eight = BinaryNode(8)
        val nine = BinaryNode(9)

        // when
        seven.leftChild = one
        one.leftChild = zero
        one.rightChild = five
        seven.rightChild = nine
        nine.leftChild = eight

        // and
        val tree = seven
        val result = mutableListOf<Int>()
        tree.traverseInOrder { result.add(it) }

        // then
        assertThat(result).isEqualTo(listOf(0, 1, 5, 7, 8, 9))
    }

    @Test
    fun `should traverse pre order`() {
        // given
        val zero = BinaryNode(0)
        val one = BinaryNode(1)
        val five = BinaryNode(5)
        val seven = BinaryNode(7)
        val eight = BinaryNode(8)
        val nine = BinaryNode(9)

        // when
        seven.leftChild = one
        one.leftChild = zero
        one.rightChild = five
        seven.rightChild = nine
        nine.leftChild = eight

        // and
        val tree = seven
        val result = mutableListOf<Int>()
        tree.traversePreOrder { result.add(it) }

        // then
        assertThat(result).isEqualTo(listOf(7, 1, 0, 5, 9, 8))
    }
}
