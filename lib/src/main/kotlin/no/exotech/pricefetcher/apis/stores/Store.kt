package no.exotech.pricefetcher.apis.stores

import no.exotech.pricefetcher.common.RequestValues

interface Store<T : Any> {
    val requestValues: RequestValues
    val responseClass: Class<T>
}