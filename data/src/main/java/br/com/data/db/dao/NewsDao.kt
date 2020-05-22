package br.com.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.domain.entity.News

@Dao
interface NewsDao {

    @Query("SELECT * FROM News WHERE id = :id")
    suspend fun getById(id : Long) : News

    @Query("SELECT * FROM News")
    suspend fun listAll() : List<News>

    @Query("SELECT * FROM News LIMIT 5")
    suspend fun listFive() : List<News>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMany(data : List<News>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOne(data : News)

}