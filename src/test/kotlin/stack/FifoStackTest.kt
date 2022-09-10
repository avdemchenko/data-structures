package stack

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FifoStackTest {

    @Test
    fun `should push and pop elements`() {
        // given
        val stack = FifoStack<String>()

        // when
        stack.push("First")
        stack.push("Second")
        stack.push("Third")

        // and
        val first = stack.pop()
        val second = stack.pop()
        val third = stack.pop()

        // then
        assertThat(first).isEqualTo("First")
        assertThat(second).isEqualTo("Second")
        assertThat(third).isEqualTo("Third")
    }
}
