package no.exotech.pricefetcher.requestvalues

interface RequestValues {
    fun getHeaders(): List<Pair<String, String>>
    fun getUrl(page: Int): String
    val pageSize: Int
    val pages: IntRange
}