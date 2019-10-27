package `in`.khofid.moviecatalogue.viewmodel

import `in`.khofid.moviecatalogue.data.source.CatalogueRepository
import `in`.khofid.moviecatalogue.di.Injection
import `in`.khofid.moviecatalogue.ui.movie.MovieViewModel
import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(val catalogeuRepository: CatalogueRepository):
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
        if(modelClass.isAssignableFrom(MovieViewModel::class.java)){
            return MovieViewModel(catalogeuRepository) as (T)
        }

        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}