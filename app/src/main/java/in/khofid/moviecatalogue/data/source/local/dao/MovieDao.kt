package `in`.khofid.moviecatalogue.data.source.local.dao

import `in`.khofid.moviecatalogue.data.model.Movie
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE

@Dao
interface MovieDao {
    @get:Query("SELECT * FROM Movie")
    val all: LiveData<List<Movie>>

    @Query("SELECT * FROM Movie")
    fun allAsPaged(): DataSource.Factory<Int, Movie>

    @Query("SELECT * FROM Movie WHERE id = :id")
    fun getById(id: Int?): Movie?

    @Insert(onConflict = REPLACE)
    fun insert(movie: Movie): Long

    @Delete
    fun delete(movie: Movie)

    @Query("DELETE FROM Movie WHERE id = :id")
    fun deleteById(id: Long): Int

    @Update
    fun update(movie: Movie): Int
}