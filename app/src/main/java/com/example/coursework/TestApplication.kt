package com.example.coursework

import android.app.Application
import com.example.coursework.Data.Database.TestDatabase
import com.example.coursework.Data.Repository.LocalTestRepository

class TestApplication: Application() {

    val database by lazy {
        TestDatabase.getDatabase(this)
    }

    val repository by lazy {
        LocalTestRepository(database.getLocalTestDao(), database.getTestDataDao())
    }

}