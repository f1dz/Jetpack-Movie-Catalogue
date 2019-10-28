package `in`.khofid.moviecatalogue.data.source

import `in`.khofid.moviecatalogue.data.model.Movie
import `in`.khofid.moviecatalogue.data.model.TvShow
import androidx.lifecycle.LiveData

interface CatalogueDataSource {

    fun getAllMovies(): LiveData<List<Movie>>

    fun getMovie(id: Int): LiveData<Movie>

    fun getAllTvShow(): LiveData<List<TvShow>>

    fun getTvShow(id: Int): LiveData<TvShow>

}