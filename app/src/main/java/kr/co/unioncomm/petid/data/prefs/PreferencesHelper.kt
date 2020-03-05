package kr.co.unioncomm.petid.data.prefs

interface PreferencesHelper {
    var prefKeyFirstSetep: Boolean
    var id: String
    var userID: String
    var password: String
    var position: String
    var group: String
    fun setStringPreferences(key: String, data: String)
    fun setIntPreferences(key: String, data: Int)
    fun setLongPreferences(key: String, data: Long?)
    fun setBooleanPreferences(key: String, data: Boolean)
    fun setLongPreferences(key: String, data: Float)
    fun getStringPreferences(key: String): String
    fun getIntPreferences(key: String): Int
    fun getLongPreferences(key: String): Long
    fun getBooleanPreferences(key: String): Boolean
    fun getFloatPreferences(key: String): Float
}
