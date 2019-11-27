package `in`.khofid.moviecatalogue.viewmodel

import `in`.khofid.moviecatalogue.data.source.CatalogueRepository
import `in`.khofid.moviecatalogue.di.Injection
import `in`.khofid.moviecatalogue.ui.detail.DetailMovieViewModel
import `in`.khofid.moviecatalogue.ui.detail.DetailTvShowViewModel
import `in`.khofid.moviecatalogue.ui.favorite.FavoriteViewModel
import `in`.khofid.moviecatalogue.ui.movie.MovieViewModel
import `in`.khofid.moviecatalogue.ui.tv.TvShowViewModel
import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(private val catalogueRepository: CatalogueRepository):
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        private var INSTANCE: ViewModelFactory? = null

        fun getInstance(application: Application): ViewModelFactory? {
            if(INSTANCE == null) {
                synchronized(ViewModelFactory::class.java) {
                    if(INSTANCE == null) {
                        INSTANCE = ViewModelFactory(Injection.provideRepository(application))
                    }
                }
            }
            return INSTANCE
        }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> MovieViewModel(catalogueRepository) as (T)
            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> DetailMovieViewModel(catalogueRepository) as (T)
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> TvShowViewModel(catalogueRepository) as (T)
            modelClass.isAssignableFrom(DetailTvShowViewModel::class.java) -> DetailTvShowViewModel(catalogueRepository) as (T)
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> FavoriteViewModel(catalogueRepository) as (T)
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }

    }
}