package no.exotech.pricefetcher

import com.google.gson.Gson

 object JsonMapper {
    @JvmStatic
    private val GSON = Gson()
    @JvmStatic
    fun <T> map(response: String, clazz: Class<T>): T {
        return GSON.fromJson(response, clazz)
    }
}