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
        var moviesResult: LiveData<List<Movie>>

        moviesResult = remoteRepository.getMovies()

        return moviesResult
    }

    override fun getMovie(id: Int): Movie {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllTvShow(): List<TvShow> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getTvShow(id: Int): TvShow {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}