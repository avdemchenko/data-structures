package list

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ArrayListTest {

    @Test
    fun `should add and get elements`() {
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
        val fourth = list.get(3)
        val fifth = list.get(4)

        // then
        assertThat(first).isEqualTo(1)
        assertThat(second).isEqualTo(2)
        assertThat(third).isEqualTo(3)
        assertThat(fourth).isNull()
        assertThat(fifth).isNull()
    }

    @Test
    fun `should add element by index`() {
        // given
        val list = ArrayList<Int>()

        // when
        list.add(1)
        list.add(2)
        list.add(3)
        list.add(2, 5)

        // and
        val first = list.get(0)
        val second = list.get(1)
        val third = list.get(2)
        val fourth = list.get(3)
        val fifth = list.get(4)

        // then
        assertThat(first).isEqualTo(1)
        assertThat(second).isEqualTo(2)
        assertThat(third).isEqualTo(5)
        assertThat(fourth).isEqualTo(3)
        assertThat(fifth).isNull()
    }

    @Test
    fun `should extend capacity twice of size with null values`() {
        // given
        val list = ArrayList<Int>()

        // when
        list.add(1)
        list.add(2)
        list.add(3)
        list.add(4)
        list.add(5)
        list.add(6)

        // and
        val fifthIndexElement = list.get(5)
        val sixthIndexElement = list.get(6)
        val seventhIndexElement = list.get(7)
        val eighthIndexElement = list.get(8)
        val ninthIndexElement = list.get(9)

        // then
        assertThat(fifthIndexElement).isEqualTo(6)
        assertThat(sixthIndexElement).isNull()
        assertThat(seventhIndexElement).isNull()
        assertThat(eighthIndexElement).isNull()
        assertThat(ninthIndexElement).isNull()
    }

    @Test
    fun `should get first element`() {
        // given
        val list = ArrayList<Int>()

        // when
        val firstNull = list.first()
        list.add(1)
        list.add(2)
        list.add(3)

        // and
        val first = list.first()

        // then
        assertThat(firstNull).isNull()
        assertThat(first).isEqualTo(1)
    }

    @Test
    fun `should not add element with wrong index`() {
        // given
        val list = ArrayList<Int>()

        // when
        list.add(1)
        list.add(2)
        list.add(3)

        // then
        assertThrows<ArrayIndexOutOfBoundsException> {
            list.get(5)
        }
    }
}
