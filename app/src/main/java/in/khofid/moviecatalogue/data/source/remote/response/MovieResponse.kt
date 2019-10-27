package `in`.khofid.moviecatalogue.data.source.remote.response

import `in`.khofid.moviecatalogue.data.model.Movie
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results")
    val results: MutableList<Movie>
)