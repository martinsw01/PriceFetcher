package no.exotech.pricefetcher.common

import kotlinx.coroutines.runBlocking
import no.exotech.pricefetcher.common.stores.Meny
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CallerTest {
    @Test
    internal fun requestsItemsWithNoProblems() = runBlocking {
        val response = Caller.call(Meny())
        assertEquals(50, response.size)
        val items = response.flatMap { it.hits } .size
        assertEquals(8202, items) // There was 8202 products as of January 1st.
    }
}