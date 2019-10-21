package `in`.khofid.moviecatalogue.ui.detail

import `in`.khofid.moviecatalogue.data.Movie
import `in`.khofid.moviecatalogue.utils.DataDummy
import androidx.lifecycle.ViewModel

class DetailMovieViewModel: ViewModel() {

    var movieId: Int = 0

    fun getMovie(): Movie {
        val movies = DataDummy.generateDummyMovies()
        return movies.filter { it.id == movieId }[0]
    }

}