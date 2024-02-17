package com.example.coursework.Data.Model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.JsonObject

@Entity(tableName = "tests_data",
    foreignKeys = arrayOf(
        ForeignKey(
            LocalTestEntity::class,
            parentColumns = arrayOf("testId"),
            childColumns = arrayOf("testId"),
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        )
    )
)
data class TestDataEntity(
    @PrimaryKey val testId: Long,
    val testJsonData: JsonObject
)
