package br.com.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Release(
    @PrimaryKey(autoGenerate = true)
    val id : Int?,
    val description : String = "",
    val title : String = "",
    val highlight : Boolean = false,
    val thumbnail : String = "",
    val videos : String = "",
    val bandName : String = ""
)
