package no.exotech.pricefetcher.common.requestvalues

class MenyRequestValues : RequestValues {
    override fun getHeaders(): List<Pair<String, String>> {
        return listOf(
            Pair("Connection", "keep-alive"),
            Pair("Host", "platform-rest-prod.ngdata.no"),
            Pair("fwc-using-csrf-token", "false"),
            Pair("fwc-using-bearer-token", "false"),
            Pair("fwc-using-api-key", "true"),
            Pair("content-type", "application/json"),
            Pair("ng-rest-api-auth-key", "Cs1T5N8XBg5HUvcfGy56"),
            Pair("Accept", "*/*"),
            Pair("Origin", "https://meny-react-prod.azurewebsites.net"),
            Pair("Referer", "https://meny-react-prod.azurewebsites.net/"),
            Pair("Accept-Language", "en-GB,en;q=0.9,nb-NO;q=0.8,nb;q=0.7,en-US;q=0.6")
        )
    }

    private val pageSize = 200
    override val pages = (1..50).toList()

    override fun getUrl(page: String): String {
        return "https://platform-rest-prod.ngdata.no/api/products/1300/7080000886050?page=$page&page_size=$pageSize" /*+
                "&full_response=true&fieldset=maximal&facets=Category%2CAllergen"*/
    }
}