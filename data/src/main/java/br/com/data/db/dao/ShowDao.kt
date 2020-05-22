package br.com.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.domain.entity.Show

@Dao
interface ShowDao {

    @Query("SELECT * FROM Show WHERE id = :id")
    suspend fun getById(id : Long) : Show

    @Query("SELECT * FROM Show")
    suspend fun listAll() : List<Show>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMany(data : List<Show>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOne(data : Show)

}