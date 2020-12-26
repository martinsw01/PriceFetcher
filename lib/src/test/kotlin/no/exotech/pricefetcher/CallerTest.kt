package no.exotech.pricefetcher

import no.exotech.pricefetcher.requestvalues.MenyRequestValues
import no.exotech.pricefetcher.requestvalues.RequestValues
import no.exotech.pricefetcher.stores.Meny
import no.exotech.pricefetcher.stores.MenyResponse
import no.exotech.pricefetcher.stores.Store
import org.junit.jupiter.api.Test

internal class CallerTest {
    @Test
    internal fun requestsItemsWithNoProblems() {
        Caller.call(Meny())
    }
}