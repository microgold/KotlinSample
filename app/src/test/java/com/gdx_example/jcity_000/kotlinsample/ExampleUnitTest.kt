package com.gdx_example.jcity_000.kotlinsample


import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun check_pricer() {
        var pricer = AlphaVantageService( ArrayList<Stock>())
        var result  = pricer.getPrice("IBM")
        println(result)
        assertTrue(result > 0)
    }

    @Test
    fun array_is_correct() {
        val array = intArrayOf(1, 2, 3, 4, 5)

        println(Arrays.toString(array))
        assertEquals(4, array[3])
    }

    @Test
    fun array_mapping_is_correct() {
        val array = intArrayOf(1, 2, 3, 4, 5)


        val mapped_array = array.map {it * 3}.toIntArray()
        println(Arrays.toString(mapped_array))
        assertEquals(12, mapped_array[3])
    }
}
