package `in`.khofid.moviecatalogue.ui.movie

import `in`.khofid.moviecatalogue.data.model.Movie
import `in`.khofid.moviecatalogue.data.source.CatalogueRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class MovieViewModel(val catalogueRepository: CatalogueRepository): ViewModel() {
    fun getMovies(): LiveData<List<Movie>> {
        return catalogueRepository.getAllMovies()
    }
}