package `in`.khofid.moviecatalogue.ui.movie

import `in`.khofid.moviecatalogue.data.Movie
import `in`.khofid.moviecatalogue.utils.DataDummy
import androidx.lifecycle.ViewModel

class MovieViewModel: ViewModel() {
    fun getMovies(): List<Movie> {
        return DataDummy.generateDummyMovies()
    }
}