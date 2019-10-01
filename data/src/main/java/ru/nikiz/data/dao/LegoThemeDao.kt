package ru.nikiz.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.nikiz.domain.LegoCategory

@Dao
interface LegoThemeDao {

    @Query("SELECT * FROM ${LegoCategory.TABLE_NAME} ORDER BY ${LegoCategory.COLUMN_ID} DESC")
    fun getThemesFromDb(): LiveData<List<LegoCategory>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllThemes(themes: List<LegoCategory>)
}