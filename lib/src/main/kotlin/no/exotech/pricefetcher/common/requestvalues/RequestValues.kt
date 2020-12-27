package no.exotech.pricefetcher.common.requestvalues

interface RequestValues {
    fun getHeaders(): List<Pair<String, String>>
    fun getUrl(page: String): String
    val pages: List<Any>
}