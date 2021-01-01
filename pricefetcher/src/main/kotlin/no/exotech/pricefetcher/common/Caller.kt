package no.exotech.pricefetcher.common

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import no.exotech.pricefetcher.common.requestvalues.RequestValues
import no.exotech.pricefetcher.common.stores.Store
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

object Caller {
    private val client = OkHttpClient().newBuilder().build()

    suspend fun <T : Any> call(store: Store<T>): List<T> {
        val deferredResponses = callAllPages(store.requestValues)
        return awaitAndMap(deferredResponses, store.map)
    }

    private suspend fun <T : Any> awaitAndMap(responses: List<Deferred<Response>>, map: (String) -> T): List<T> {
        return responses.mapNotNull { response ->
            response.await().body?.let {
                map(it.string())
            }
        }
    }

    private suspend fun callAllPages(requestValues: RequestValues) = withContext(Dispatchers.IO){
        val requestBuilder = RequestBuilder.getRequestBuilder(requestValues)
        requestValues.pages.map { page ->
            callStoreAsync(requestBuilder.withPage(page.toString()), this)
        }
    }

    private fun callStoreAsync(request: Request, scope: CoroutineScope) = scope.async {
        client.newCall(request).execute()
    }
}