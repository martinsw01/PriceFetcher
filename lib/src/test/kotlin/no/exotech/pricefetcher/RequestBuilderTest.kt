package no.exotech.pricefetcher

import no.exotech.pricefetcher.requestvalues.MenyRequestValues
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test

internal class RequestBuilderTest {
    @Test
    internal fun returnsSameBuilder() {
        val firstBuilder = RequestBuilder.getRequestBuilder(MenyRequestValues())
        val secondBuilder = RequestBuilder.getRequestBuilder(MenyRequestValues())
        assertEquals(firstBuilder, secondBuilder)
    }

    @Test
    internal fun differentPagesYieldsDifferentRequest() {
        val builder = RequestBuilder.getRequestBuilder(MenyRequestValues())
        val pageOneRequest = builder.withPage(1)
        val pageTwoRequest = builder.withPage(2)
        assertNotEquals(pageOneRequest, pageTwoRequest)
    }
}