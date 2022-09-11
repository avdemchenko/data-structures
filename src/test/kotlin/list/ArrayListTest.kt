package list

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ArrayListTest {

    @Test
    fun `should add elements`() {
        // given
        val list = ArrayList<Int>()

        // when
        list.add(1)
        list.add(2)
        list.add(3)

        // and
        val first = list.get(0)
        val second = list.get(1)
        val third = list.get(2)

        // then
        assertThat(first).isEqualTo(1)
        assertThat(second).isEqualTo(2)
        assertThat(third).isEqualTo(3)
    }
}
