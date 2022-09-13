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
}