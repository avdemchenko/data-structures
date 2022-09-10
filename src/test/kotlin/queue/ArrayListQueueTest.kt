package queue

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ArrayListQueueTest {

    @Test
    fun `should add and remove elements from array queue`() {
        // given
        val queue = ArrayListQueue<String>()

        // when
        val firstElement = queue.enqueue("First")
        val secondElement = queue.enqueue("Second")
        val thirdElement = queue.enqueue("Third")

        // and
        val firstEnqueued = queue.dequeue()
        val secondEnqueued = queue.dequeue()
        val thirdEnqueued = queue.dequeue()
        val nullEnqueued = queue.dequeue()

        // then
        assertThat(firstElement).isEqualTo(true)
        assertThat(secondElement).isEqualTo(true)
        assertThat(thirdElement).isEqualTo(true)

        // and
        assertThat(firstEnqueued).isEqualTo("First")
        assertThat(secondEnqueued).isEqualTo("Second")
        assertThat(thirdEnqueued).isEqualTo("Third")
        assertThat(nullEnqueued).isNull()
    }
}
