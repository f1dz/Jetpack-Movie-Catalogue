package `in`.khofid.moviecatalogue.data.source.local

import `in`.khofid.moviecatalogue.data.model.Movie
import `in`.khofid.moviecatalogue.data.model.TvShow
import `in`.khofid.moviecatalogue.data.source.local.dao.MovieDao
import `in`.khofid.moviecatalogue.data.source.local.dao.TvShowDao
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Movie::class, TvShow::class], version = 2, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao

    companion object {
        private const val DB_NAME = "tmdb"
        private var dbInstance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            if(dbInstance == null) {
                dbInstance = Room
                    .databaseBuilder(context.applicationContext, AppDatabase::class.java, DB_NAME)
                    .allowMainThreadQueries()
                    .build()
            }
            return dbInstance as AppDatabase
        }
    }
}