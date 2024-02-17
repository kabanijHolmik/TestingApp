package com.example.coursework.Data.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "local_tests")
data class LocalTestEntity(
    @PrimaryKey(autoGenerate = true)
    val testId: Long,
    val userId: Long,
    val testName: String,
    val testDescription: String,
    val testType: String,
    var testCreationDate: Date?,
    var userScore: Float
)

