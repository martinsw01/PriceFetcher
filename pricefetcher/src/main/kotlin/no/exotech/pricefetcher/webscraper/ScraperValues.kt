package no.exotech.pricefetcher.webscraper

import it.skrape.selects.DocElement

interface ScraperValues<T> {
    val uniqueIdentifiers: Iterable<String>
    val itemIdentifier: String
    val itemMapper: DocElement.() -> T
}