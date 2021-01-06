package no.exotech.pricefetcher.common

import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking
import no.exotech.pricefetcher.Caller
import no.exotech.pricefetcher.stores.Kolonial
import no.exotech.pricefetcher.stores.Meny
import no.exotech.pricefetcher.stores.MenyResponse
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class CallerTest {

    private fun testMenyResponse(response: List<MenyResponse>) {
        assertEquals(50, response.size)
        val products = response.flatMap { it.hits }.size
        assertTrue(products > 8000)
    }

    @Test
    internal fun doesNotThrowNullPointerException() = runBlocking {
        val responses = arrayOf(Meny(), Kolonial()).map {
            async { it.javaClass.name to Caller.call(it) }
        }.awaitAll().toMap()
        @Suppress("UNCHECKED_CAST")
        testMenyResponse(responses[Meny::class.java.name] as List<MenyResponse>)
    }
}