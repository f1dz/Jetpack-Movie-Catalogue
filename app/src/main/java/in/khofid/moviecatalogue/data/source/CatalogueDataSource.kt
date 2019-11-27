package `in`.khofid.moviecatalogue.data.source

import `in`.khofid.moviecatalogue.data.model.Movie
import `in`.khofid.moviecatalogue.data.model.TvShow
import androidx.lifecycle.LiveData
import androidx.paging.PagedList

interface CatalogueDataSource {

    fun getAllMovies(page: Int): LiveData<List<Movie>>

    fun getMovie(id: Int): LiveData<Movie>

    fun getAllTvShow(page: Int): LiveData<List<TvShow>>

    fun getTvShow(id: Int): LiveData<TvShow>

    fun getAllFavoriteMovies(): LiveData<PagedList<Movie>>

    fun addFavoriteMovie(movie: Movie)

    fun removeFavoriteMovie(movie: Movie)

    fun isFavoritedMovie(movie: Movie): Boolean

    fun getAllFavoriteTvShows(): LiveData<PagedList<TvShow>>

    fun addFavoriteTvShow(tvShow: TvShow)

    fun removeFavoriteTvShow(tvShow: TvShow)

    fun isFavoriteTvShow(tvShow: TvShow): Boolean
}