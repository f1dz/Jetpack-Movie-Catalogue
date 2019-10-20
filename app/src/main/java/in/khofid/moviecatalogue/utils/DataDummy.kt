package `in`.khofid.moviecatalogue.utils

import `in`.khofid.moviecatalogue.data.MovieResponse
import `in`.khofid.moviecatalogue.data.TvResponse
import android.content.Context
import com.google.gson.Gson
import java.io.IOException
import java.io.InputStream


object DataDummy {

    var gson = Gson()

    fun generateDummyMovies(context: Context) =
        gson.fromJson(loadJSON(context, "movies.json"), MovieResponse::class.java).results

    fun generateDummyTvShow(context: Context) =
        gson.fromJson(loadJSON(context, "tv.json"), TvResponse::class.java).results

    fun loadJSON(context: Context, fileSource: String): String? {
        var json: String? = null
        try {
            var input: InputStream = context.assets.open(fileSource)
            val size = input.available()
            val buffer = ByteArray(size)
            input.read(buffer)
            input.close()
            json = String(buffer, charset("UTF-8"))

        } catch (ex: IOException) {}

        return json
    }
}