package ru.nikiz.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = LegoSet.TABLE_NAME)
data class LegoSet(
    @PrimaryKey
    @field:SerializedName(COLUMN_SET_NUM)
    val id: String,
    @field:SerializedName(COLUMN_NAME)
    val name: String,
    @field:SerializedName(COLUMN_SET_IMG_URL)
    val imageUrl: String? = null,
    @field:SerializedName(COLUMN_THEME_ID)
    val themeId: Int,
    @field:SerializedName(COLUMN_LAST_MODIFIED_DATE)
    val lastModifiedDate: String? = null,
    @field:SerializedName(COLUMN_NUM_PARTS)
    val numParts: Int? = null,
    @field:SerializedName(COLUMN_SET_URL)
    val url: String? = null,
    @field:SerializedName(COLUMN_YEAR)
    val year: Int? = null
) {
    override fun toString() = name

    companion object {
        const val TABLE_NAME = "sets"
        const val COLUMN_NAME = "name"
        const val COLUMN_SET_NUM = "set_num"
        const val COLUMN_SET_IMG_URL = "set_img_url"
        const val COLUMN_THEME_ID = "theme_id"
        const val COLUMN_LAST_MODIFIED_DATE = "last_modified_dt"
        const val COLUMN_NUM_PARTS = "num_parts"
        const val COLUMN_SET_URL = "set_url"
        const val COLUMN_YEAR = "year"
    }
}