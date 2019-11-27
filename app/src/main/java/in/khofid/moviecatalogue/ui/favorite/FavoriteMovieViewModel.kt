package `in`.khofid.moviecatalogue.ui.favorite

import `in`.khofid.moviecatalogue.data.source.CatalogueRepository
import androidx.lifecycle.ViewModel

class FavoriteMovieViewModel(private val catalogueRepository: CatalogueRepository): ViewModel() {
    fun getMovies() = catalogueRepository.getAllFavoriteMovies()
}