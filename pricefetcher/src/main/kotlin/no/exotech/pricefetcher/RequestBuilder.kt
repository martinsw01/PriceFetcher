package no.exotech.pricefetcher

import no.exotech.pricefetcher.requestvalues.RequestValues
import okhttp3.Headers
import okhttp3.Request
import org.slf4j.LoggerFactory
import java.util.concurrent.ConcurrentHashMap

class RequestBuilder private constructor(private val requestValues: RequestValues) {
    private val requestBuilder = createRequestBuilder()

    fun withPage(page: String): Request {
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
        return requestValues.headers.flatMap { it.toList() }.toTypedArray()
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(RequestBuilder::class.java)
        private val requestBuilders = ConcurrentHashMap<Class<out RequestValues>, RequestBuilder>() // Thread safe mutable map

        fun getRequestBuilder(requestValues: RequestValues): RequestBuilder {
            val clazz = requestValues.javaClass
            if (clazz !in requestBuilders.keys) {
                LOGGER.debug("Creating request builder for ${clazz.simpleName}")
                requestBuilders[clazz] = RequestBuilder(requestValues)
            }
            return requestBuilders[clazz]!!
        }
    }
}