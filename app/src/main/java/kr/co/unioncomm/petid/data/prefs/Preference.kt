package kr.co.unioncomm.petid.data.prefs

import android.content.Context
import android.content.SharedPreferences
import kr.co.unioncomm.petid.data.ApiConstants
import kr.co.unioncomm.petid.util.Trace

import javax.inject.Inject

class Preference @Inject
constructor(context: Context) : PreferencesHelper {

    private val mPreferences: SharedPreferences =
        context.getSharedPreferences(ApiConstants.PREF_NAME, Context.MODE_PRIVATE)
    private var  mEditor: SharedPreferences.Editor

    override var prefKeyFirstSetep: Boolean
        get() {
            Trace.d("getPrefKeyFirstSetep")
            return getBooleanPreferences(PREF_KEY_FIRST_SETEP)
        }
        set(use) {
            Trace.d("setPrefKeyFirstSetep:$use")
            setBooleanPreferences(PREF_KEY_FIRST_SETEP, use)
        }

    override var id: String
        get() {
            Trace.d("getID")
            return getStringPreferences(PREF_KEY_ID)
        }
        set(id) {
            Trace.d("setID:$id")
            setStringPreferences(PREF_KEY_ID, id)
        }

    override var userID: String
        get() {
            Trace.d("getUserID")
            return getStringPreferences(PREF_KEY_USERID)
        }
        set(id) {
            Trace.d("setUserID:$id")
            setStringPreferences(PREF_KEY_USERID, id)
        }

    override var password: String
        get() {
            Trace.d("getPassword")
            return getStringPreferences(PREF_KEY_PASSWORD)
        }
        set(password) {
            Trace.d("setPassword:$password")
            setStringPreferences(PREF_KEY_PASSWORD, password)
        }

    override var position: String
        get() {
            Trace.d("getPosition")
            return getStringPreferences(PREF_KEY_POSITION)
        }
        set(position) {
            Trace.d("setPosition:$position")
            setStringPreferences(PREF_KEY_POSITION, position)
        }

    override var group: String
        get() {
            Trace.d("getGroup")
            return getStringPreferences(PREF_KEY_GROUP)
        }
        set(Group) {
            Trace.d("setPosition:$Group")
            setStringPreferences(PREF_KEY_GROUP, Group)
        }

    init {
        mEditor = mPreferences.edit()
    }

    override fun setStringPreferences(key: String, data: String) {
        mEditor.putString(key, data)
        mEditor.apply()
    }

    override fun setIntPreferences(key: String, data: Int) {
        mEditor.putInt(key, data)
        mEditor.apply()
    }

    override fun setLongPreferences(key: String, data: Long?) {
        mEditor.putLong(key, data!!)
        mEditor.apply()
    }

    override fun setBooleanPreferences(key: String, data: Boolean) {
        mEditor.putBoolean(key, data)
        mEditor.apply()
    }

    override fun setLongPreferences(key: String, data: Float) {
        mEditor.putFloat(key, data)
        mEditor.apply()
    }

    override fun getStringPreferences(key: String): String {
        return mPreferences.getString(key, "") ?: ""
    }

    override fun getIntPreferences(key: String): Int {
        return mPreferences.getInt(key, 0)
    }

    override fun getLongPreferences(key: String): Long {
        return mPreferences.getLong(key, 0L)
    }

    override fun getBooleanPreferences(key: String): Boolean {
        return mPreferences.getBoolean(key, false)
    }

    override fun getFloatPreferences(key: String): Float {
        return mPreferences.getFloat(key, 0f)
    }

    companion object {
        private val PREF_KEY_FIRST_SETEP = "PREF_KEY_FIRST_SETEP"
        private val PREF_KEY_ID = "PREF_KEY_ID"
        private val PREF_KEY_USERID = "PREF_KEY_USERID"
        private val PREF_KEY_PASSWORD = "PREF_KEY_PASSWORD"
        private val PREF_KEY_POSITION = "PREF_KEY_POSITION"
        private val PREF_KEY_GROUP = "PREF_KEY_GROUP"
    }
}
