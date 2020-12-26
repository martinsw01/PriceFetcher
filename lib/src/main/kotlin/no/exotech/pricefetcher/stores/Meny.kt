package no.exotech.pricefetcher.stores

import no.exotech.pricefetcher.requestvalues.MenyRequestValues
import no.exotech.pricefetcher.requestvalues.RequestValues

data class Meny(
    override val requestValues: RequestValues = MenyRequestValues(),
    override val responseClass: Class<MenyResponse> = MenyResponse::class.java
) : Store<MenyResponse>