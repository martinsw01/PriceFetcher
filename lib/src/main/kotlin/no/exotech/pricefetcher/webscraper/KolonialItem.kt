package no.exotech.pricefetcher.webscraper

data class KolonialItem(
    val product: String,
    val description: String,
    val pricePerUnit: Double,
    val pricePerKg: Double
)
