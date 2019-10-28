package `in`.khofid.moviecatalogue.data.source.remote

import `in`.khofid.moviecatalogue.data.model.Movie
import `in`.khofid.moviecatalogue.data.model.TvShow
import `in`.khofid.moviecatalogue.data.source.remote.response.MovieResponse
import `in`.khofid.moviecatalogue.data.source.remote.response.TvResponse
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val TAG = "RemoteRepository"
class RemoteRepository {
    private val apiClient = ApiClient.getClient().create(ApiInterface::class.java)

    companion object {
        fun getInstance(): RemoteRepository {
            return RemoteRepository()
        }
    }

    fun getMovies(): LiveData<List<Movie>>{
        var movies: MutableLiveData<List<Movie>> = MutableLiveData()
        apiClient.movies().enqueue(
            object : Callback<MovieResponse>{
                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    Log.d(TAG, t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    response.body()?.let { movies.postValue(it.results) }
                }

            }
        )
        return movies
    }

    fun getMovie(id: Int): LiveData<Movie>{
        var movie: MutableLiveData<Movie> = MutableLiveData()
        apiClient.movie(id).enqueue(
            object : Callback<Movie> {
                override fun onFailure(call: Call<Movie>, t: Throwable) {
                    Log.d(TAG, t.localizedMessage)
                }

                override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                    movie.postValue(response.body())
                }

            }
        )
        return  movie
    }

    fun getTvShows(): LiveData<List<TvShow>> {
        var tvShows: MutableLiveData<List<TvShow>> = MutableLiveData()
        apiClient.tvShows().enqueue(
            object : Callback<TvResponse>{
                override fun onFailure(call: Call<TvResponse>, t: Throwable) {
                    Log.d(TAG, t.localizedMessage)
                }

                override fun onResponse(call: Call<TvResponse>, response: Response<TvResponse>) {
                    response.body()?.let { tvShows.postValue(it.results) }
                }

            }
        )
        return  tvShows
    }
}