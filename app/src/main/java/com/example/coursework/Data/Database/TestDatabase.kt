package com.example.coursework.Data.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.coursework.Data.Converter.DateConverter
import com.example.coursework.Data.Converter.JsonObjectConverter
import com.example.coursework.Data.Dao.LocalTestDao
import com.example.coursework.Data.Dao.TestDataDao
import com.example.coursework.Data.Model.LocalTestEntity
import com.example.coursework.Data.Model.TestDataEntity

@Database(version = 1,
    entities = [
        TestDataEntity::class,
        LocalTestEntity::class
    ],
    exportSchema = false
)
@TypeConverters(DateConverter::class, JsonObjectConverter::class)
abstract class TestDatabase: RoomDatabase() {

    abstract fun getLocalTestDao(): LocalTestDao
    abstract fun getTestDataDao(): TestDataDao

    companion object{
        @Volatile
        private var INSTANCE: TestDatabase? = null

        fun getDatabase(context: Context): TestDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,
                    TestDatabase::class.java,
                    "test_database").build()

                INSTANCE = instance

                instance
            }
        }
    }
}
