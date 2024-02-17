package com.example.coursework.Data.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.coursework.Data.Model.TestDataEntity
import com.google.gson.JsonObject

@Dao
interface TestDataDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTestData(testData: TestDataEntity)

//    @Query("SELECT testJsonData FROM tests_data WHERE testId = :testId")
//    suspend fun getTestData(testId: Long): JsonObject?

    @Update
    suspend fun updateTestData(testData: TestDataEntity)

    @Delete
    suspend fun deleteTestData(testData: TestDataEntity)


}