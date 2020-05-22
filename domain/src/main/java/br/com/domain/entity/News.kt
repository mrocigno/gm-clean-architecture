package br.com.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "News")
data class News(
    @PrimaryKey(autoGenerate = false)
    val id : Long?,
    val views : Long?,
    val title : String?,
    val thumbnail : String?,
    val author : String?,
    val description : String?
)