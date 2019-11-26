package `in`.khofid.moviecatalogue.data.source

import `in`.khofid.moviecatalogue.data.model.Movie
import `in`.khofid.moviecatalogue.data.model.TvShow
import androidx.lifecycle.LiveData

interface CatalogueDataSource {

    fun getAllMovies(): LiveData<List<Movie>>

    fun getMovie(id: Int): LiveData<Movie>

    fun getAllTvShow(): LiveData<List<TvShow>>

    fun getTvShow(id: Int): LiveData<TvShow>

    fun getAllFavoriteMovies(): LiveData<List<Movie>>

    fun addFavoriteMovie(movie: Movie)

    fun removeFavoriteMovie(movie: Movie)

    fun isFavoritedMovie(movie: Movie): Boolean

    fun getAllFavoriteTvShows(): LiveData<List<TvShow>>

    fun addFavoriteTvShow(tvShow: TvShow)

    fun removeFavoriteTvShow(tvShow: TvShow)

    fun isFavoriteTvShow(tvShow: TvShow): Boolean
}