package br.com.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.domain.entity.Gender

@Dao
interface GenderDao {

    @Query("SELECT * FROM Gender WHERE id = :id")
    suspend fun getById(id : Int) : Gender

    @Query("SELECT * FROM Gender")
    suspend fun listAll() : List<Gender>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMany(data : List<Gender>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOne(data : Gender)

}