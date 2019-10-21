package `in`.khofid.moviecatalogue.ui.detail

import `in`.khofid.moviecatalogue.R
import `in`.khofid.moviecatalogue.data.Movie
import `in`.khofid.moviecatalogue.utils.Constants
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_movie.*

class DetailMovieActivity : AppCompatActivity() {

    private var movieId: Int = 0
    lateinit var movie: Movie
    private lateinit var viewModel: DetailMovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        movieId = intent.getIntExtra("movieId", 0)

        viewModel = ViewModelProviders.of(this).get(DetailMovieViewModel::class.java)
        viewModel.movieId = movieId
        movie = viewModel.getMovie()

        tvTitle.text = movie.title
        tvDescription.text = movie.description
        ratingBar.rating = movie.vote/2

        Glide.with(this)
            .load(Constants.IMG_URL + movie.backdrop)
            .into(imgBackdrop)


        Glide.with(this)
            .load(Constants.IMG_URL + movie.poster)
            .into(imgPoster)
    }
}
