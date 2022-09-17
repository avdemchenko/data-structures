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
    fun `should add elements`() {
        // given
        val list = LinkedListCustom<Int>()

        // when
        list.add(1)
        list.add(2)
        list.add(3)
        list.add(4)
        list.add(5)

        // then
        assertThat(list.size()).isEqualTo(5)
        println(list.visualise())
    }

    @Test
    fun `should is empty`() {
        // given
        val list = LinkedListCustom<Int>()

        // when
        val beforeAddingElements = list.isEmpty()
        list.add(1)
        val afterAddingElements = list.isEmpty()

        // then
        assertThat(beforeAddingElements).isTrue
        assertThat(afterAddingElements).isFalse
    }
}
