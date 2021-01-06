package no.exotech.pricefetcher.stores

import no.exotech.pricefetcher.JsonMapper
import no.exotech.pricefetcher.requestvalues.MenyRequestValues
import no.exotech.pricefetcher.requestvalues.RequestValues

class Meny : Store<MenyResponse> {
    override val requestValues: RequestValues = MenyRequestValues()
    override val map: (response: String) -> MenyResponse = { response ->
        JsonMapper.map(response, MenyResponse::class.java)
    }
}