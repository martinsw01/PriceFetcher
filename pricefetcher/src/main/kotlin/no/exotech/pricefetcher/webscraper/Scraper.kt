package no.exotech.pricefetcher.webscraper

import it.skrape.core.htmlDocument
import it.skrape.selects.DocElement

object Scraper {
    @JvmStatic
    fun <T> scrape(html: String, scraperValues: ScraperValues<T>): List<T> {
        val body = htmlDocument(html)
            .findFirst("body")
        val wrapperElement = foldToWrapper(body, scraperValues.uniqueIdentifiers)
        return wrapperElement.findAll(scraperValues.itemIdentifier)
            .map(scraperValues.itemMapper)
    }

    @JvmStatic
    private fun foldToWrapper(body: DocElement, uniqueIdentifiers: Iterable<String>): DocElement {
        return uniqueIdentifiers.fold(body) {element: DocElement, identifier: String ->
            element.findFirst(identifier)
        }
    }
}