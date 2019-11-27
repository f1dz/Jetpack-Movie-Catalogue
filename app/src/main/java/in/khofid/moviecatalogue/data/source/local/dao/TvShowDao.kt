package `in`.khofid.moviecatalogue.data.source.local.dao

import `in`.khofid.moviecatalogue.data.model.TvShow
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface TvShowDao {
    @get:Query("SELECT * FROM TvShow")
    val all: LiveData<List<TvShow>>

    @Query("SELECT * FROM TvShow")
    fun allAsPaged(): DataSource.Factory<Int, TvShow>

    @Query("SELECT * FROM TvShow WHERE id = :id")
    fun getById(id: Int?): TvShow?

    @Insert(onConflict = REPLACE)
    fun insert(tvShow: TvShow)

    @Delete
    fun delete(tvShow: TvShow)
}