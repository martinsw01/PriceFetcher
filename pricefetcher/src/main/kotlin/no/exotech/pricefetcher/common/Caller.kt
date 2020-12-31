package no.exotech.pricefetcher.common

import no.exotech.pricefetcher.common.requestvalues.RequestValues
import no.exotech.pricefetcher.common.stores.Store
import okhttp3.OkHttpClient
import okhttp3.Response
import java.util.stream.Collectors

object Caller {
    @JvmStatic
    private val CLIENT = OkHttpClient().newBuilder().build()

    @JvmStatic
    fun <T : Any> call(store: Store<T>): List<T> {
        val responses = callAllPages(store.requestValues)
        return mapResponses(responses, store.mapper)
    }

    @JvmStatic
    private fun <T : Any> mapResponses(responses: List<Response>, map: (response: String) -> T): List<T> {
        return responses.mapNotNull { response ->
            response.body?.string()?.let {
                map(it)
            }
        }
    }

    @JvmStatic
    private fun callAllPages(requestValues: RequestValues): List<Response> {
        val requestBuilder = RequestBuilder.getRequestBuilder(requestValues)
        return requestValues.pages.parallelMap { page ->
            CLIENT.newCall(requestBuilder.withPage("$page")).execute()
        }
    }

    @JvmStatic
    private fun <R, T> List<T>.parallelMap(mapper: (t: T) -> R): List<R> {
        return this
            .parallelStream()
            .map { mapper(it) }
            .collect(Collectors.toList())
    }
}