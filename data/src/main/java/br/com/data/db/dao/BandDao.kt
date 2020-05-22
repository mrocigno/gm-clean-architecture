package br.com.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.domain.entity.Band

@Dao
interface BandDao {

    @Query("SELECT * FROM Band WHERE id = :id")
    suspend fun getById(id : Int) : Band

    @Query("SELECT * FROM Band")
    suspend fun listAll() : List<Band>

    @Query("SELECT * FROM Band LIMIT 5")
    suspend fun listFive() : List<Band>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMany(data : List<Band>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOne(data : Band)

}