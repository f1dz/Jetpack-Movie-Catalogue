package `in`.khofid.moviecatalogue.data.source

import `in`.khofid.moviecatalogue.data.model.Movie
import `in`.khofid.moviecatalogue.data.model.TvShow
import `in`.khofid.moviecatalogue.data.source.remote.RemoteRepository
import androidx.lifecycle.LiveData

class CatalogueRepository(val remoteRepository: RemoteRepository): CatalogueDataSource {

    companion object {
        fun getInstance(remoteRepository: RemoteRepository): CatalogueRepository {
            return CatalogueRepository(remoteRepository)
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
}