package no.exotech.pricefetcher.common.stores

import no.exotech.pricefetcher.common.requestvalues.RequestValues

interface Store<T : Any> {
    val requestValues: RequestValues
    val map: (response: String) -> T
}