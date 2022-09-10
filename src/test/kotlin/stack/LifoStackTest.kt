package stack

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LifoStackTest {

    @Test
    fun `should push and pop elements`() {
        // given
        val stack = LifoStack<String>()

        // when
        stack.push("First")
        stack.push("Second")
        stack.push("Third")

        // and
        val third = stack.pop()
        val second = stack.pop()
        val first = stack.pop()

        // then
        assertThat(third).isEqualTo("Third")
        assertThat(second).isEqualTo("Second")
        assertThat(first).isEqualTo("First")
    }
}
