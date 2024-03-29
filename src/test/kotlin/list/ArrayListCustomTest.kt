package list

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ArrayListCustomTest {

    @Test
    fun `should add and get elements`() {
        // given
        val list = ArrayListCustom<Int>()

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
        val list = ArrayListCustom<Int>()

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
        val list = ArrayListCustom<Int>()

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
        val list = ArrayListCustom<Int>()

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
    fun `should get last element`() {
        // given
        val list = ArrayListCustom<Int>()

        // when
        val lastNull = list.last()
        list.add(1)
        list.add(2)
        list.add(3)
        list.add(4)
        list.add(5)

        // and
        val last = list.last()

        // then
        assertThat(lastNull).isNull()
        assertThat(last).isEqualTo(5)
    }

    @Test
    fun `should set element`() {
        // given
        val list = ArrayListCustom<Int>()

        // when
        list.add(1)
        list.add(2)
        list.add(3)

        // and
        list.set(1, 10)

        // and
        val updated = list.get(1)

        // then
        assertThat(updated).isEqualTo(10)
    }

    @Test
    fun `should remove element`() {
        // given
        val list = ArrayListCustom<Int>()

        // when
        list.add(1)
        list.add(2)
        list.add(3)

        // and
        val removed = list.remove(1)

        // and
        val shiftedElement = list.get(1)

        // then
        assertThat(removed).isEqualTo(2)
        assertThat(shiftedElement).isEqualTo(3)
    }

    @Test
    fun `should verify if element contains`() {
        // given
        val list = ArrayListCustom<Int>()

        // when
        list.add(1)
        list.add(2)
        list.add(3)

        // and
        val containedElement = list.contains(3)
        val missedElement = list.contains(5)

        // then
        assertThat(containedElement).isTrue
        assertThat(missedElement).isFalse
    }

    @Test
    fun `should verify if list is empty`() {
        // given
        val list = ArrayListCustom<Int>()

        // when
        val emptyResult = list.isEmpty()

        // and
        list.add(1)
        list.add(2)
        list.add(3)

        // and
        val notEmptyResult = list.isEmpty()

        // then
        assertThat(emptyResult).isTrue
        assertThat(notEmptyResult).isFalse
    }

    @Test
    fun `should calculate size`() {
        // given
        val list = ArrayListCustom<Int>()

        // when
        list.add(1)
        list.add(2)
        list.add(3)

        // and
        val listSize = list.size()

        // then
        assertThat(listSize).isEqualTo(3)
    }

    @Test
    fun `should clear list`() {
        // given
        val list = ArrayListCustom<Int>()

        // when
        list.add(1)
        list.add(2)
        list.add(3)

        // and
        val listSizeBeforeClear = list.size()
        val firstElementBeforeClear = list.get(0)
        val secondElementBeforeClear = list.get(1)
        val thirdElementBeforeClear = list.get(2)

        // and
        list.clear()
        val listSizeAfterClear = list.size()
        val firstElementAfterClear = list.get(0)
        val secondElementAfterClear = list.get(1)
        val thirdElementAfterClear = list.get(2)

        // then
        assertThat(listSizeBeforeClear).isEqualTo(3)
        assertThat(listSizeAfterClear).isEqualTo(0)

        // and
        assertThat(firstElementBeforeClear).isEqualTo(1)
        assertThat(secondElementBeforeClear).isEqualTo(2)
        assertThat(thirdElementBeforeClear).isEqualTo(3)

        // and
        assertThat(firstElementAfterClear).isNull()
        assertThat(secondElementAfterClear).isNull()
        assertThat(thirdElementAfterClear).isNull()
    }

    @Test
    fun `should not add element with wrong index`() {
        // given
        val list = ArrayListCustom<Int>()

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
