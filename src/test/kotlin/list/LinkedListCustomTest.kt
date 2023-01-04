package list

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LinkedListCustomTest {

    @Test
    fun `should verify size`() {
        // given
        val list = LinkedListCustom<String>()

        // when
        val emptyCondition = list.isEmpty()

        // then
        assertThat(emptyCondition).isTrue()
    }

    @Test
    fun `should push elements`() {
        // given
        val list = LinkedListCustom<Int>()

        // when
        list.push(1)
        list.push(2)
        list.push(3)
        list.push(4)
        list.push(5)

        // then
        assertThat(list.size()).isEqualTo(5)
    }

    @Test
    fun `should append elements`() {
        // given
        val list = LinkedListCustom<Int>()

        // when
        list.append(1)
        list.append(2)
        list.append(3)
        list.append(4)
        list.append(5)

        // then
        assertThat(list.size()).isEqualTo(5)
    }

    @Test
    fun `should get node by index`() {
        // given
        val list = LinkedListCustom<Int>()

        // when
        list.push(1)
        list.push(2)
        list.push(3)

        // and
        val node = list.nodeAt(1)

        // then
        assertThat(node?.value).isEqualTo(2)
    }

    @Test
    fun `should insert node`() {
        // given
        val list = LinkedListCustom<Int>()

        // when
        list.push(1)
        list.push(2)
        list.push(3)

        // and
        val middleNode = list.nodeAt(1)
        list.insert(10, middleNode!!)

        // and
        val result = list.nodeAt(2)

        // then
        assertThat(result?.value).isEqualTo(10)
    }

    @Test
    fun `should pop element`() {
        // given
        val list = LinkedListCustom<Int>()

        // when
        list.push(1)
        list.push(2)
        list.push(3)

        // and
        val result = list.pop()

        // then
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun `should verify is empty`() {
        // given
        val list = LinkedListCustom<Int>()

        // when
        val beforeAddingElements = list.isEmpty()
        list.push(1)
        val afterAddingElements = list.isEmpty()

        // then
        assertThat(beforeAddingElements).isTrue
        assertThat(afterAddingElements).isFalse
    }
}
