package `in`.khofid.moviecatalogue.ui.detail

import `in`.khofid.moviecatalogue.data.model.Movie
import `in`.khofid.moviecatalogue.data.source.CatalogueRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class DetailMovieViewModel(
    private val catalogueRepository: CatalogueRepository
): ViewModel() {

    var movieId: Int = 0

    fun getMovie(): LiveData<Movie> {
        return catalogueRepository.getMovie(movieId)
    }

    fun addFavorite(movie: Movie) {
        catalogueRepository.addFavorite(movie)
    }

    fun removeFavorite(movie: Movie) {
        catalogueRepository.removeFavorite(movie)
    }

    fun isFavorited(movie: Movie): Boolean {
        return catalogueRepository.isFavorited(movie)
    }
}