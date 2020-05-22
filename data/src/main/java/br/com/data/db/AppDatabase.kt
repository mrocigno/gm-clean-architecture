package br.com.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.data.db.dao.*
import br.com.domain.entity.*

@Database(entities = [
    News::class,
    Band::class,
    Show::class,
    Gender::class,
    Release::class
], version = 2)
abstract class AppDatabase : RoomDatabase() {

    abstract fun newsDao() : NewsDao
    abstract fun bandDao() : BandDao
    abstract fun showDao() : ShowDao
    abstract fun genderDao() : GenderDao
    abstract fun releaseDao() : ReleaseDao

}