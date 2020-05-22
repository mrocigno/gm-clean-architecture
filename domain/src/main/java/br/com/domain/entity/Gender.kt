package br.com.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Gender(
    @PrimaryKey(autoGenerate = false)
    val id : Int = -1,
    val slug : String = "",
    val gender : String = ""
)