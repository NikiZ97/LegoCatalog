package ru.nikiz.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.nikiz.domain.LegoSet

@Dao
interface LegoSetDao {

    @Query("SELECT * FROM ${LegoSet.TABLE_NAME} WHERE themeId = :themeId ORDER BY ${LegoSet.COLUMN_YEAR} DESC")
    fun getSetsByTheme(themeId: Int): LiveData<List<LegoSet>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllSets(sets: List<LegoSet>)
}