package no.exotech.pricefetcher.stores

import no.exotech.pricefetcher.requestvalues.KolonialRequestValues
import no.exotech.pricefetcher.webscraper.KolonialItem
import no.exotech.pricefetcher.webscraper.KolonialScraperValues
import no.exotech.pricefetcher.webscraper.Scraper

class Kolonial : Store<List<KolonialItem>> {
    override val requestValues = KolonialRequestValues()
    override val map: (response: String) -> List<KolonialItem> = {
        Scraper.scrape(it, KolonialScraperValues())
    }
}