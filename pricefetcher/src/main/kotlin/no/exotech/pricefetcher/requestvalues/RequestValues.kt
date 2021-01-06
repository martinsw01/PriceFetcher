package no.exotech.pricefetcher.requestvalues

interface RequestValues {
    val headers: List<Pair<String, String>>
    fun getUrl(page: String): String
    val pages: List<Any>
}