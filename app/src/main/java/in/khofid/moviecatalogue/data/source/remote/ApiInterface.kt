package `in`.khofid.moviecatalogue.data.source.remote

import `in`.khofid.moviecatalogue.data.source.remote.response.MovieResponse
import `in`.khofid.moviecatalogue.utils.Constants.API_KEY
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("movie/popular?api_key=$API_KEY")
    fun movies(): Call<MovieResponse>

}