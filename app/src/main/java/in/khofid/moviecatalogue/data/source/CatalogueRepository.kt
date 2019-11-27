package `in`.khofid.moviecatalogue.data.source

import `in`.khofid.moviecatalogue.data.model.Movie
import `in`.khofid.moviecatalogue.data.model.TvShow
import `in`.khofid.moviecatalogue.data.source.local.LocalRepository
import `in`.khofid.moviecatalogue.data.source.remote.RemoteRepository
import androidx.lifecycle.LiveData

class CatalogueRepository(
    private val remoteRepository: RemoteRepository,
    private val localRepository: LocalRepository
): CatalogueDataSource {

    companion object {
        fun getInstance(remoteRepository: RemoteRepository, localRepository: LocalRepository): CatalogueRepository {
            return CatalogueRepository(remoteRepository, localRepository)
        }
    }

    override fun getAllMovies(): LiveData<List<Movie>> {
        return remoteRepository.getMovies()
    }

    override fun getMovie(id: Int): LiveData<Movie> {
        return remoteRepository.getMovie(id)
    }

    override fun getAllTvShow(): LiveData<List<TvShow>> {
        return remoteRepository.getTvShows()
    }

    override fun getTvShow(id: Int): LiveData<TvShow> {
        return remoteRepository.getTvShow(id)
    }

    override fun getAllFavoriteMovies() = localRepository.getAllMovies()

    override fun addFavoriteMovie(movie: Movie) {
        localRepository.addFavoriteMovie(movie)
    }

    override fun removeFavoriteMovie(movie: Movie) {
        localRepository.removeFavoriteMovie(movie)
    }

    override fun isFavoritedMovie(movie: Movie) =
        localRepository.isFavoritedMovie(movie)

    override fun getAllFavoriteTvShows() = localRepository.getAllTvShow()

    override fun addFavoriteTvShow(tvShow: TvShow) {
        localRepository.addFavoriteTvShow(tvShow)
    }

    override fun removeFavoriteTvShow(tvShow: TvShow) {
        localRepository.removeFavoriteTvShow(tvShow)
    }

    override fun isFavoriteTvShow(tvShow: TvShow) =
        localRepository.isFavoritedTvShow(tvShow)


}