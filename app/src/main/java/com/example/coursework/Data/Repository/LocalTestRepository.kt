package com.example.coursework.Data.Repository

import androidx.annotation.WorkerThread
import com.example.coursework.Data.Dao.LocalTestDao
import com.example.coursework.Data.Dao.TestDataDao
import com.example.coursework.Data.Model.LocalTestEntity
import com.example.coursework.Data.Model.TestDataEntity
import kotlinx.coroutines.flow.Flow

class LocalTestRepository(private val localTestDao: LocalTestDao, private val testDataDao: TestDataDao) {

    val allLocalTests: Flow<List<LocalTestEntity>> = localTestDao.getAllLocalTests()

    @WorkerThread
    suspend fun insertTest(localTest: LocalTestEntity){
        localTestDao.insertLocalTest(localTest)
    }

    @WorkerThread
    suspend fun insertTestData(testData: TestDataEntity){
        testDataDao.insertTestData(testData)
    }

    @WorkerThread
    suspend fun updateTest(localTest: LocalTestEntity){
        localTestDao.updateLocalTest(localTest)
    }

    @WorkerThread
    suspend fun updateTestData(testData: TestDataEntity){
        testDataDao.updateTestData(testData)
    }

    @WorkerThread
    suspend fun deleteTest(localTest: LocalTestEntity){
        localTestDao.deleteLocalTest(localTest)
    }

    @WorkerThread
    suspend fun deleteTestData(testData: TestDataEntity){
        testDataDao.deleteTestData(testData)
    }

    @WorkerThread
    suspend fun deleteAllTests(){
        localTestDao.deleteAllLocalTest()
    }

    @WorkerThread
    suspend fun getTest(localTest: LocalTestEntity){
        localTestDao.getLocalTestById(localTest.testId)
    }

    @WorkerThread
    suspend fun getTestData(testData: TestDataEntity){
        testDataDao.deleteTestData(testData)
    }
}