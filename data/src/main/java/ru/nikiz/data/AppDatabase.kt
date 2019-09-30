package ru.nikiz.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.nikiz.data.dao.LegoSetDao
import ru.nikiz.data.dao.LegoThemeDao
import ru.nikiz.domain.LegoCategory
import ru.nikiz.domain.LegoSet

@Database(entities = [LegoCategory::class, LegoSet::class], version = 2, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun legoThemeDao(): LegoThemeDao
    abstract fun legoSetDao(): LegoSetDao

    companion object {

        private const val DATABASE_NAME = "lego-db"

        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
        }
    }

}