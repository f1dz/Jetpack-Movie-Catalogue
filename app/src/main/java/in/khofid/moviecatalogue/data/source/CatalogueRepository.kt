package `in`.khofid.moviecatalogue.data.source

import `in`.khofid.moviecatalogue.data.model.Movie
import `in`.khofid.moviecatalogue.data.model.TvShow
import `in`.khofid.moviecatalogue.data.source.local.LocalRepository
import `in`.khofid.moviecatalogue.data.source.remote.RemoteRepository
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList

class CatalogueRepository(
    private val remoteRepository: RemoteRepository,
    private val localRepository: LocalRepository
): CatalogueDataSource {

    companion object {
        fun getInstance(remoteRepository: RemoteRepository, localRepository: LocalRepository): CatalogueRepository {
            return CatalogueRepository(remoteRepository, localRepository)
        }
    }

    override fun getAllMovies(page: Int): LiveData<List<Movie>> {
        return remoteRepository.getMovies(page)
    }

    override fun getMovie(id: Int): LiveData<Movie> {
        return remoteRepository.getMovie(id)
    }

    override fun getAllTvShow(page: Int): LiveData<List<TvShow>> {
        return remoteRepository.getTvShows(page)
    }

    override fun getTvShow(id: Int): LiveData<TvShow> {
        return remoteRepository.getTvShow(id)
    }

    override fun getAllFavoriteMovies(): LiveData<PagedList<Movie>> {
        return LivePagedListBuilder(localRepository.getFavoriteMoviesPaged(), 10).build()
    }

    override fun addFavoriteMovie(movie: Movie) {
        localRepository.addFavoriteMovie(movie)
    }

    override fun removeFavoriteMovie(movie: Movie) {
        localRepository.removeFavoriteMovie(movie)
    }

    override fun isFavoritedMovie(movie: Movie) =
        localRepository.isFavoritedMovie(movie)

    override fun getAllFavoriteTvShows(): LiveData<PagedList<TvShow>>{
        return LivePagedListBuilder(localRepository.getFavoriteTvShowPaged(), 10).build()
    }

    override fun addFavoriteTvShow(tvShow: TvShow) {
        localRepository.addFavoriteTvShow(tvShow)
    }

    override fun removeFavoriteTvShow(tvShow: TvShow) {
        localRepository.removeFavoriteTvShow(tvShow)
    }

    override fun isFavoriteTvShow(tvShow: TvShow) =
        localRepository.isFavoritedTvShow(tvShow)


}