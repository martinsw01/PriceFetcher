package no.exotech.pricefetcher.webscraper

import kotlinx.coroutines.runBlocking
import no.exotech.pricefetcher.common.Caller
import no.exotech.pricefetcher.common.stores.Kolonial
import org.junit.jupiter.api.Test

internal class ScraperTest {
    @Test
    internal fun throwsNoException() { runBlocking {
        Caller.call(Kolonial())
    }}
}