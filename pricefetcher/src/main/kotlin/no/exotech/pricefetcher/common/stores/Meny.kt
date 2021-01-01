package no.exotech.pricefetcher.common.stores

import no.exotech.pricefetcher.apis.JsonMapper
import no.exotech.pricefetcher.common.requestvalues.MenyRequestValues
import no.exotech.pricefetcher.common.requestvalues.RequestValues

class Meny : Store<MenyResponse> {
    override val requestValues: RequestValues = MenyRequestValues()
    override val map: (response: String) -> MenyResponse = { response ->
        JsonMapper.map(response, MenyResponse::class.java)
    }
}