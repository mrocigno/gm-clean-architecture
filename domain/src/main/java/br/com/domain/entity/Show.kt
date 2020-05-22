package br.com.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Show (
    @PrimaryKey(autoGenerate = false)
    val id : Long = -1L,
    val description : String = "",
    val banner : String = "",
    val genderId : Int = -1,
    val title : String = "",
    val highlight : Boolean = false,
    val thumbnailUrl : String = "",
    val establishment : String = "",
    val localization : String = ""
)