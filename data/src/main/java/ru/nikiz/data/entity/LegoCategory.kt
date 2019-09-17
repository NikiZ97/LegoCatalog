package ru.nikiz.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = LegoCategory.TABLE_NAME)
class LegoCategory(
    @PrimaryKey
    @field:SerializedName(COLUMN_ID)
    val id: Int,
    @field:SerializedName(COLUMN_NAME)
    val name: String,
    @field:SerializedName(COLUMN_PARENT_ID)
    val parentId: Int? = null
) {
    companion object {
        const val TABLE_NAME = "category"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
        const val COLUMN_PARENT_ID = "parent_id"
    }

    override fun toString() = name
}