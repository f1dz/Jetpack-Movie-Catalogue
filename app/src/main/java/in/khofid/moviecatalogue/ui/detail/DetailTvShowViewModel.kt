package `in`.khofid.moviecatalogue.ui.detail

import `in`.khofid.moviecatalogue.data.model.TvShow
import `in`.khofid.moviecatalogue.data.source.CatalogueRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class DetailTvShowViewModel(private val catalogueRepository: CatalogueRepository): ViewModel() {

    var tvShowId: Int = 0

    fun getTvShow(): LiveData<TvShow> {
        return catalogueRepository.getTvShow(tvShowId)
    }

    fun addFavorite(tvShow: TvShow) {
        catalogueRepository.addFavoriteTvShow(tvShow)
    }

    fun removeFavorite(tvShow: TvShow) {
        catalogueRepository.removeFavoriteTvShow(tvShow)
    }

    fun isFavorited(tvShow: TvShow) = catalogueRepository.isFavoriteTvShow(tvShow)
}