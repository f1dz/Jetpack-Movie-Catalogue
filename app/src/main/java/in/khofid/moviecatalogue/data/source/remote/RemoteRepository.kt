package `in`.khofid.moviecatalogue.data.source.remote

import `in`.khofid.moviecatalogue.data.model.Movie
import `in`.khofid.moviecatalogue.data.source.remote.response.MovieResponse
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
                    Log.d("RemoteRepository", t.localizedMessage)
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
}