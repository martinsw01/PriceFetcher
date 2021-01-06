package no.exotech.pricefetcher

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import no.exotech.pricefetcher.requestvalues.RequestValues
import no.exotech.pricefetcher.stores.Store
import okhttp3.OkHttpClient
import org.slf4j.LoggerFactory
import java.io.IOException

object Caller {
    private val client = OkHttpClient().newBuilder().build()
    private val LOGGER = LoggerFactory.getLogger(Caller::class.java)

    suspend fun <T : Any> call(store: Store<T>): List<T> {
        LOGGER.info("Calling ${store.javaClass.simpleName}")
        val deferredResponses = callAllPagesAsync(store.requestValues)
        return awaitAndMap(deferredResponses, store.map)
    }

    private suspend fun <T : Any> awaitAndMap(responses: List<Deferred<String?>>, map: (String) -> T): List<T> {
        return responses.mapNotNull { response ->
            response.await()?.let { map(it) }
        }
    }

    private suspend fun callAllPagesAsync(requestValues: RequestValues) = withContext(Dispatchers.IO) {
        val requestBuilder = RequestBuilder.getRequestBuilder(requestValues)
        requestValues.pages.map { page ->
            async { callPage(requestBuilder, page) }
        }
    }

    private fun callPage(requestBuilder: RequestBuilder, page: Any): String? {
        val request = requestBuilder.withPage("$page")
        val call = client.newCall(request)
        LOGGER.debug("Calling page: $page, ${request.url.host}")
        return try {
            call.execute().use { it.body?.string() }
        } catch (e: IOException) {
            LOGGER.warn("Failed to call store. Is there an internet connection?", e)
            return null
        }
    }
}