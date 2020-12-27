package no.exotech.pricefetcher.common

import no.exotech.pricefetcher.common.stores.Meny
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CallerTest {
    @Test
    internal fun requestsItemsWithNoProblems() {
        val response = Caller.call(Meny())
        assertEquals(25, response.size)
    }
}