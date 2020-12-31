package no.exotech.pricefetcher.common.stores

import no.exotech.pricefetcher.common.requestvalues.RequestValues

interface Store<T : Any> {
    val requestValues: RequestValues
    val responseClass: Class<T>
    val mapper: (response: String) -> T
}