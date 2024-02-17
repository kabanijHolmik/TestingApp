package com.example.coursework.Data.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.coursework.Data.Model.LocalTestEntity
import com.example.coursework.Data.Model.TestDataEntity
import com.example.coursework.Data.Repository.LocalTestRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class LocalTestViewModel(private val repository: LocalTestRepository): ViewModel() {

    val allTests: LiveData<List<LocalTestEntity>> = repository.allLocalTests.asLiveData()

    fun insertTest(localTest: LocalTestEntity) = viewModelScope.launch(Dispatchers.IO){
        repository.insertTest(localTest)
    }

    fun insertTestData(testData: TestDataEntity) = viewModelScope.launch(Dispatchers.IO){
        repository.insertTestData(testData)
    }

    fun updateTest(localTest: LocalTestEntity) = viewModelScope.launch(Dispatchers.IO){
        repository.updateTest(localTest)
    }

    fun updateTestData(testData: TestDataEntity) = viewModelScope.launch(Dispatchers.IO){
        repository.updateTestData(testData)
    }

    fun deleteTest(localTest: LocalTestEntity) = viewModelScope.launch(Dispatchers.IO){
        repository.deleteTest(localTest)
    }

    fun deleteTestData(testData: TestDataEntity) = viewModelScope.launch(Dispatchers.IO){
        repository.deleteTestData(testData)
    }

    fun deleteAllTests() = viewModelScope.launch(Dispatchers.IO){
        repository.deleteAllTests()
    }

    fun getTest(localTest: LocalTestEntity) = viewModelScope.launch(Dispatchers.IO){
        repository.getTest(localTest)
    }

    fun getTestData(testData: TestDataEntity) = viewModelScope.launch(Dispatchers.IO){
        repository.getTestData(testData)
    }

}

class LocalTestViewModelFactory(private var repository: LocalTestRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(LocalTestViewModel::class.java)){
            return LocalTestViewModel(repository) as T
        } else{
            throw IllegalArgumentException("Unknown ViewModel")
        }
    }
}