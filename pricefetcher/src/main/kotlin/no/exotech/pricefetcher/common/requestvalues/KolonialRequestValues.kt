package no.exotech.pricefetcher.common.requestvalues

class KolonialRequestValues : RequestValues {
    override val headers = emptyList<Pair<String, String>>()

    override val pages = listOf(
        // Frukt og grønt
        "/20-frukt-og-gront/21-frukt/",
        "/20-frukt-og-gront/423-baer/",
        "/20-frukt-og-gront/422-ferdig-kuttede-salater/",
        "/20-frukt-og-gront/391-salater-og-kal/",
        "/20-frukt-og-gront/325-ferdigkuttet-frukt-og-gront/",
        "/20-frukt-og-gront/22-gronnsaker/?page=1",
        "/20-frukt-og-gront/22-gronnsaker/?page=2",
        "/20-frukt-og-gront/443-okologisk-frukt-og-gront/",
        "/20-frukt-og-gront/347-poteter/",
        "/20-frukt-og-gront/23-urter-og-spirer/",
        "/20-frukt-og-gront/24-fro-notter-og-torket-frukt/?page=1",
        "/20-frukt-og-gront/24-fro-notter-og-torket-frukt/?page=2",
        "/20-frukt-og-gront/9-hermetisert-frukt-og-gront/?page=1",
        "/20-frukt-og-gront/9-hermetisert-frukt-og-gront/?page=2",
        "/20-frukt-og-gront/57-frossen-frukt-og-gront/",

        // Mathall
        "/488-mathall/489-kjottdisken/",
        "/488-mathall/498-fiskedisken/",
        "/488-mathall/492-brod-og-bakevarer/",
        "/488-mathall/499-ostedisken/",
        "/488-mathall/490-meieri-og-egg/",
        "/488-mathall/491-drikke/",
        "/488-mathall/495-palegg-og-spekemat/",
        "/488-mathall/493-middagstilbehor-pasta-og-saus/",
        "/488-mathall/494-mel-og-gryn/",
        "/488-mathall/497-iskrem-sotsaker-og-snacks/",

        // Hopper over 'Class Olson', 'Iceland' og 'Blomster og planter

        // Brød og frokostblandinger
        "/1-brod-og-frokostblandinger/2-ferske-brod/",
        "/1-brod-og-frokostblandinger/456-fersk-smabakst/",
        "/1-brod-og-frokostblandinger/393-langtidsholdbare-brod/",
        "/1-brod-og-frokostblandinger/99-frosne-brod-og-rundstykker/",
        "/1-brod-og-frokostblandinger/4-knekkebrod/?page=1",
        "/1-brod-og-frokostblandinger/4-knekkebrod/?page=2",
        "/1-brod-og-frokostblandinger/6-polse-og-hamburgerbrod-lomper/",
        "/1-brod-og-frokostblandinger/13-frokostblandinger/",
        "/1-brod-og-frokostblandinger/116-deiger-og-bunner/",
        "/1-brod-og-frokostblandinger/256-pasmurt/",

        // Melk, meieriprodukter og egg
        "/48-melk-meieriprodukter-og-egg/49-melk/",
        "/48-melk-meieriprodukter-og-egg/487-plantebasert-drikke/",
        "/48-melk-meieriprodukter-og-egg/53-smor-og-margarin/",
        "/48-melk-meieriprodukter-og-egg/50-egg/",
        "/48-melk-meieriprodukter-og-egg/52-flote-og-rommeprodukter/",
        "/48-melk-meieriprodukter-og-egg/51-yoghurt?page=1",
        "/48-melk-meieriprodukter-og-egg/51-yoghurt?page=2",

        //  Kjøtt og kylling
        "/26-kjott-og-kylling/388-storfe/",
        "/26-kjott-og-kylling/389-svin/",
        "/26-kjott-og-kylling/28-kylling-kalkun-and/",
        "/26-kjott-og-kylling/390-lam-og-vilt/",
        "/26-kjott-og-kylling/204-bacon-og-tilbehor/",
        "/26-kjott-og-kylling/304-kjottdeig-og-karbonadedeig/",
        "/26-kjott-og-kylling/307-hamburgere/",
        "/26-kjott-og-kylling/310-kjottboller-og-karbonader/",
        "/26-kjott-og-kylling/29-polser/"

        // ...
    )

    override fun getUrl(page: String): String {
        return "https://kolonial.no/kategorier$page"
    }
}
