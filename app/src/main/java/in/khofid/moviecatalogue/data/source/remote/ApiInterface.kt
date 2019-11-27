package `in`.khofid.moviecatalogue.data.source.remote

import `in`.khofid.moviecatalogue.data.model.Movie
import `in`.khofid.moviecatalogue.data.model.TvShow
import `in`.khofid.moviecatalogue.data.source.remote.response.MovieResponse
import `in`.khofid.moviecatalogue.data.source.remote.response.TvResponse
import `in`.khofid.moviecatalogue.utils.Constants.API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("movie/popular?api_key=$API_KEY")
    fun movies(@Query("page") page: Int): Call<MovieResponse>

    @GET("movie/{id}?api_key=$API_KEY")
    fun movie(@Path("id") id: Int): Call<Movie>

    @GET("tv/popular?api_key=$API_KEY")
    fun tvShows(@Query("page") page: Int): Call<TvResponse>

    @GET("tv/{id}?api_key=$API_KEY")
    fun tvShow(@Path("id") id: Int): Call<TvShow>
}