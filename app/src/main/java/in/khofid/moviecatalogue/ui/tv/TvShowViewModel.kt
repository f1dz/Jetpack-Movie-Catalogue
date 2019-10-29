package `in`.khofid.moviecatalogue.ui.tv

import `in`.khofid.moviecatalogue.data.model.TvShow
import `in`.khofid.moviecatalogue.data.source.CatalogueRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class TvShowViewModel(private val catalogueRepository: CatalogueRepository): ViewModel() {
    fun getTvShows(): LiveData<List<TvShow>> {
        return catalogueRepository.getAllTvShow()
    }
}