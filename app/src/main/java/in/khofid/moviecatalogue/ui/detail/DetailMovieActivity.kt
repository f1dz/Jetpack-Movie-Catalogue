package `in`.khofid.moviecatalogue.ui.detail

import `in`.khofid.moviecatalogue.R
import `in`.khofid.moviecatalogue.data.model.Movie
import `in`.khofid.moviecatalogue.utils.Constants
import `in`.khofid.moviecatalogue.viewmodel.ViewModelFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_movie.*

class DetailMovieActivity : AppCompatActivity() {

    private var movieId: Int = 0
    lateinit var movie: LiveData<Movie>
    private lateinit var viewModel: DetailMovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        movieId = intent.getIntExtra("movieId", 0)

        viewModel = obtainViewModel(this)
        viewModel.movieId = movieId

        viewModel.getMovie().observe(this, Observer { movie ->

            tvTitle.text = movie.title
            tvDescription.text = movie.description
            ratingBar.rating = (movie.vote / 2)

            Glide.with(this)
                .load(Constants.IMG_URL + movie.backdrop)
                .into(imgBackdrop)


            Glide.with(this)
                .load(Constants.IMG_URL + movie.poster)
                .into(imgPoster)
        })
    }

    fun obtainViewModel(activity: DetailMovieActivity): DetailMovieViewModel{
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProviders.of(activity, factory).get(DetailMovieViewModel::class.java)
    }
}
