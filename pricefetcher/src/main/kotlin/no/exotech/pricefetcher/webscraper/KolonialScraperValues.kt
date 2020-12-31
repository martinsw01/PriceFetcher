package no.exotech.pricefetcher.webscraper

import it.skrape.selects.DocElement

class KolonialScraperValues : ScraperValues<KolonialItem> {
    override val uniqueIdentifiers: Iterable<String> = listOf(
        ".product-category-list",
        ".row"
    )

    override val itemIdentifier = ".product-list-item"

    override val itemMapper: DocElement.() -> KolonialItem = {
        val product = this.findFirst(".name-main").text
        val description = this.findFirst(".name-extra").text
        val pricePerUnit = getPricePerUnit(this).formatToDouble()
        val pricePerKg = findFirst(".unit-price").text.formatToDouble()
        KolonialItem(product, description, pricePerUnit, pricePerKg)
    }

    private fun getPricePerUnit(element: DocElement): String {
        return try {
            element.findFirst(".label-price").text
        } catch (ignore: IndexOutOfBoundsException) {
            element.findFirst(".price").text.drop(6)
        }
    }

    private fun String.formatToDouble(): Double {
        return this
            .replace(Regex("[A-Za-z ]"), "")
            .replace(",", ".")
            .toDouble()
    }
}
