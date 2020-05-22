package br.com.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Band")
data class Band(
    @PrimaryKey(autoGenerate = false)
    val id : Int = -1,
    val name : String = "",
    val banner : String = "",
    val views : Long = -1L,
    val genderId : Int = -1,
    val shows : Int = -1,
    val logo : String = ""
)
