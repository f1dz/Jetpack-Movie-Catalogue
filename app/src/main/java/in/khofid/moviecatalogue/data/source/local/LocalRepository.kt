package `in`.khofid.moviecatalogue.data.source.local

import `in`.khofid.moviecatalogue.data.model.Movie
import `in`.khofid.moviecatalogue.data.source.local.dao.MovieDao
import android.content.Context
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LocalRepository(context: Context) {

    private val movieDao: MovieDao

    init {
        val db = AppDatabase.getDatabase(context)
        movieDao = db.movieDao()
    }

    companion object {
        fun getInstance(context: Context): LocalRepository {
            return LocalRepository(context)
        }
    }

    fun getAllMovies(): LiveData<List<Movie>> {
        return movieDao.all
    }


    fun addFavorite(movie: Movie) {
        GlobalScope.launch(Dispatchers.Main) { movieDao.insert(movie) }
    }

    fun removeFavorite(movie: Movie) {
        GlobalScope.launch(Dispatchers.Main) { movieDao.delete(movie) }
    }

    fun isFavorited(movie: Movie): Boolean {
        return movieDao.getById(movie.id) != null
    }
}