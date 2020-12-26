package no.exotech.pricefetcher

import no.exotech.pricefetcher.apis.Caller
import no.exotech.pricefetcher.apis.stores.Meny
import org.junit.jupiter.api.Test

internal class CallerTest {
    @Test
    internal fun requestsItemsWithNoProblems() {
        Caller.call(Meny())
    }
}