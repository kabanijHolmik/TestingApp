package com.example.coursework.Data.Converter

import androidx.room.TypeConverter
import com.google.gson.JsonObject
import com.google.gson.JsonParser

class JsonObjectConverter {

    @TypeConverter
    fun fromJsonObject(jsonObject: JsonObject?): String? {
        return jsonObject?.toString()
    }

    @TypeConverter
    fun toJsonObject(jsonString: String?): JsonObject? {
        return try {
            JsonParser.parseString(jsonString).asJsonObject
        } catch (e: Exception) {
            null
        }
    }

}