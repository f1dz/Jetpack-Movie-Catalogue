package `in`.khofid.moviecatalogue.ui.detail

import `in`.khofid.moviecatalogue.R
import `in`.khofid.moviecatalogue.utils.Constants
import `in`.khofid.moviecatalogue.utils.hide
import `in`.khofid.moviecatalogue.utils.show
import `in`.khofid.moviecatalogue.utils.year
import `in`.khofid.moviecatalogue.viewmodel.ViewModelFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_tv_show.*

class DetailTvShowActivity : AppCompatActivity() {

    private var tvShowId: Int = 0
    private lateinit var viewModel: DetailTvShowViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tv_show)

        progressBar.show()

        tvShowId = intent.getIntExtra("tvShowId", 0)

        viewModel = obtainViewModel(this)
        viewModel.tvShowId = tvShowId
        viewModel.getTvShow().observe(this, Observer { tvShow ->
            tvTitle.text = tvShow.title
            tvYear.text = tvShow.firstAirDate.year()
            tvDescription.text = tvShow.description
            ratingBar.rating = (tvShow.rating / 2)

            Glide.with(this)
                .load(Constants.IMG_URL + tvShow.backdrop)
                .into(imgBackdrop)


            Glide.with(this)
                .load(Constants.IMG_URL + tvShow.poster)
                .into(imgPoster)

            progressBar.hide()
        })
    }

    private fun obtainViewModel(activity: DetailTvShowActivity): DetailTvShowViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProviders.of(activity, factory).get(DetailTvShowViewModel::class.java)
    }

}
