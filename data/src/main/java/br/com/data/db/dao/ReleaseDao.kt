package br.com.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.domain.entity.News
import br.com.domain.entity.Release

@Dao
interface ReleaseDao {

    @Query("SELECT * FROM `Release` WHERE id = :id")
    suspend fun getById(id : Int) : Release

    @Query("SELECT * FROM `Release`")
    suspend fun listAll() : List<Release>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMany(data : List<Release>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOne(data : Release)

}