package no.exotech.pricefetcher.webscraper

import no.exotech.pricefetcher.common.Caller
import no.exotech.pricefetcher.common.stores.Kolonial
import org.junit.jupiter.api.Test

internal class ScraperTest {
    @Test
    internal fun throwsNoException() {
        Caller.call(Kolonial.get())
    }
}