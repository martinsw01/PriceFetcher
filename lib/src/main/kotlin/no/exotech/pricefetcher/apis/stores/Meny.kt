package no.exotech.pricefetcher.apis.stores

import no.exotech.pricefetcher.common.MenyRequestValues
import no.exotech.pricefetcher.common.RequestValues

data class Meny(
    override val requestValues: RequestValues = MenyRequestValues(),
    override val responseClass: Class<MenyResponse> = MenyResponse::class.java
) : Store<MenyResponse>