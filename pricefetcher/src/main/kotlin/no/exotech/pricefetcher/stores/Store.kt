package no.exotech.pricefetcher.stores

import no.exotech.pricefetcher.requestvalues.RequestValues

interface Store<T : Any> {
    val requestValues: RequestValues
    val map: (response: String) -> T
}