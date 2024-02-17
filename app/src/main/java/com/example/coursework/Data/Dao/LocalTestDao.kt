package com.example.coursework.Data.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.coursework.Data.Model.LocalTestEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LocalTestDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertLocalTest(localTest: LocalTestEntity)

    @Update
    suspend fun updateLocalTest(localTest: LocalTestEntity)

    @Query("SELECT * FROM local_tests")
    fun getAllLocalTests(): Flow<List<LocalTestEntity>>

    @Query("SELECT * FROM local_tests WHERE testId = :testId")
    suspend fun getLocalTestById(testId: Long): LocalTestEntity?

    @Query("DELETE FROM local_tests")
    suspend fun deleteAllLocalTest()

    @Delete
    suspend fun deleteLocalTest(localTest: LocalTestEntity)

}