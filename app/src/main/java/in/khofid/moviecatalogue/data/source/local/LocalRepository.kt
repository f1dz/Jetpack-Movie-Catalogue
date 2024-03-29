package `in`.khofid.moviecatalogue.data.source.local

import `in`.khofid.moviecatalogue.data.model.Movie
import `in`.khofid.moviecatalogue.data.model.TvShow
import `in`.khofid.moviecatalogue.data.source.local.dao.MovieDao
import `in`.khofid.moviecatalogue.data.source.local.dao.TvShowDao
import android.content.Context
import androidx.paging.DataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LocalRepository(context: Context) {

    private val movieDao: MovieDao
    private val tvShowDao: TvShowDao

    init {
        val db = AppDatabase.getDatabase(context)
        movieDao = db.movieDao()
        tvShowDao = db.tvShowDao()
    }

    companion object {
        fun getInstance(context: Context): LocalRepository {
            return LocalRepository(context)
        }
    }

    fun getFavoriteMoviesPaged(): DataSource.Factory<Int, Movie> {
        return movieDao.allAsPaged()
    }

    fun addFavoriteMovie(movie: Movie) {
        GlobalScope.launch(Dispatchers.Main) { movieDao.insert(movie) }
    }

    fun removeFavoriteMovie(movie: Movie) {
        GlobalScope.launch(Dispatchers.Main) { movieDao.delete(movie) }
    }

    fun isFavoritedMovie(movie: Movie): Boolean {
        return movieDao.getById(movie.id) != null
    }

    fun getFavoriteTvShowPaged(): DataSource.Factory<Int, TvShow> {
        return tvShowDao.allAsPaged()
    }

    fun addFavoriteTvShow(tvShow: TvShow) {
        GlobalScope.launch(Dispatchers.Main) { tvShowDao.insert(tvShow) }
    }

    fun removeFavoriteTvShow(tvShow: TvShow) {
        GlobalScope.launch(Dispatchers.Main) { tvShowDao.delete(tvShow) }
    }

    fun isFavoritedTvShow(tvShow: TvShow): Boolean {
        return tvShowDao.getById(tvShow.id) != null
    }
}