package no.exotech.pricefetcher.common.stores

import no.exotech.pricefetcher.common.requestvalues.KolonialRequestValues
import no.exotech.pricefetcher.webscraper.KolonialItem
import no.exotech.pricefetcher.webscraper.KolonialScraperValues
import no.exotech.pricefetcher.webscraper.Scraper

class Kolonial private constructor() : Store<List<KolonialItem>> {
    override val requestValues = KolonialRequestValues()
    override val responseClass = KOLONIAL_ITEM_LIST_CLASS
    override val mapper: (response: String) -> List<KolonialItem> = {
        Scraper.scrape(it, KolonialScraperValues())
    }

    companion object {
        @JvmStatic
        private val KOLONIAL_ITEM_LIST_CLASS = listOf<KolonialItem>().javaClass

        @JvmStatic
        private val instance = Kolonial()
        @JvmStatic
        fun get(): Kolonial {
            return instance
        }
    }
}