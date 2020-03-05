package kr.co.unioncomm.petid.data.model

import androidx.room.TypeConverter

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import java.lang.reflect.Type
import java.util.ArrayList

class Converters {

    @TypeConverter
    fun gettingListFromString(genreIds: String?): IntArray {
        if (genreIds == null) {
            return IntArray(0)
        }
        val array = genreIds.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val result = IntArray(array.size)
        for (i in array.indices) {
            if (!array[i].isEmpty()) {
                try {
                    result[i] = Integer.parseInt(array[i])
                } catch (e: Exception) {
                    result[i] = 0
                }

            }
        }
        return result
    }

    @TypeConverter
    fun writingStringFromList(list: IntArray?): String? {
        if (list == null) {
            return null
        }
        var genreIds = ""
        for (i in list) {
            genreIds += ",$i"
        }
        return genreIds
    }

    companion object {

        @TypeConverter
        fun fromString(value: String): ArrayList<String>? {
            val listType = object : TypeToken<ArrayList<String>>() {

            }.type
            return Gson().fromJson<ArrayList<String>>(value, listType)
        }

        @TypeConverter
        fun fromArrayList(list: ArrayList<String>): String {
            val gson = Gson()
            return gson.toJson(list)
        }
    }
}
