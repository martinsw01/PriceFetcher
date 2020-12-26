package no.exotech.pricefetcher

import no.exotech.pricefetcher.requestvalues.RequestValues
import okhttp3.Headers
import okhttp3.Request

class RequestBuilder private constructor(private val requestValues: RequestValues) {
    private val requestBuilder = createRequestBuilder()

    fun withPage(page: Int): Request {
        return requestBuilder
            .url(requestValues.getUrl(page))
            .build()
    }

    private fun createRequestBuilder(): Request.Builder {
        val headers = Headers.headersOf(*flattenHeaders())
        return Request.Builder()
            .method("GET", null)
            .headers(headers)
    }

    private fun flattenHeaders(): Array<String> {
        return requestValues.getHeaders().flatMap { it.toList() }.toTypedArray()
    }

    companion object {
        private val requestBuilders = mutableMapOf<Class<out RequestValues>, RequestBuilder>()

        fun getRequestBuilder(requestValues: RequestValues): RequestBuilder {
            val clazz = requestValues.javaClass
            if (clazz !in requestBuilders.keys)
                createRequestBuilder(requestValues)
            return requestBuilders[clazz] as RequestBuilder
        }

        private fun createRequestBuilder(requestValues: RequestValues) {
            requestBuilders[requestValues.javaClass] = RequestBuilder(requestValues)
        }
    }
}