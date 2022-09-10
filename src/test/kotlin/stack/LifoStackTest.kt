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

    @Test
    fun `should peek element`() {
        // given
        val stack = LifoStack<String>()

        // when
        stack.push("First")

        // and
        val peek = stack.peek()
        val first = stack.pop()

        // then
        assertThat(peek).isEqualTo("First")
        assertThat(first).isEqualTo("First")
    }

    @Test
    fun `should create stack from list`() {
        // given
        val list = arrayListOf("First", "Second", "Third")

        // when
        val stack = LifoStack.create(list)

        // and
        val first = stack.pop()
        val second = stack.pop()
        val third = stack.pop()

        // then
        assertThat(first).isEqualTo("Third")
        assertThat(second).isEqualTo("Second")
        assertThat(third).isEqualTo("First")
    }
}
